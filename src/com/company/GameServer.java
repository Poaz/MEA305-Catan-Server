package com.company;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameServer extends Listener {

    private static final int port = 23820;
    private static Server server;
    //Containing connections
    private static final Map<Integer, PlayerStats> players = new HashMap<Integer, PlayerStats>();

    public static void main(String[] args) throws IOException {

        //Initialize the server
        server = new Server(16384, 2048);


        //Classes that needs to be registered into KryoNet so they can be sent.
        server.getKryo().register(PlayerStats.class);
        server.getKryo().register(int[].class);
        server.getKryo().register(SharedData.class);

        //Binding the server port
        server.bind(port, port);

        //Start the server
        server.start();

        //Add a listener to the server
        server.addListener(new GameServer());

        //Prints to server console
        System.out.println("The server is ready!");
    }

    public void connected(Connection c) {

        //Making a player object
        PlayerStats player = new PlayerStats();

        //Making a PacketAddPlayer object
        PlayerStats packet = new PlayerStats();

        //Setting the ID in the PacketAddPlayer class to whatever ID comes from the connection.
        packet.ID = c.getID();

        //Sends all a new list of connection names.
        server.sendToAllExceptTCP(c.getID(), packet);

        /*
        for (PlayerStats p : players.values()) {
            PlayerStats packet2 = new PlayerStats();
            packet2.ID = p.c.getID();
            c.sendTCP(packet2);
        }
        */

        //Sets players in player map.
        players.put(c.getID(), player);
        //Prints to server console
        System.out.println("Connection received");
        Log.set(Log.LEVEL_DEBUG);
    }

    public void received(Connection c, Object o) {

        if (o instanceof PlayerStats) {
            //Makes a packet of the PacketAddPlayer and sets it equal to the incoming object.
            PlayerStats playerPacket = (PlayerStats) o;

            //Adds name to the connection ID in a string array carrying all names.
            SharedData.names[c.getID()] = ((PlayerStats) o).name;
            //Points acquired by each player.
            SharedData.points[c.getID()] = playerPacket.point;
            //Knights played by player, in an int array.
            SharedData.knightsPlayed[c.getID()] = playerPacket.knights_played;
            //Lobby Ready boolean array
            SharedData.lobbyReady[c.getID()] = playerPacket.lobbyReady;
            //Longest Road
            SharedData.longestRoad[c.getID()] = playerPacket.length_of_road;
            //Resources on hand.
            SharedData.resourcesOnHand[c.getID()] = playerPacket.resources_on_hand;
            //Turn order, determined by player ID
            //SharedData.turn = playerPacket.

            //Point
            //Sets the temp to the real class.
            players.get(c.getID()).point = playerPacket.point;

            //Sends all a new list of connection names.
            server.sendToAllExceptUDP(c.getID(), playerPacket);

            //Prints to server console
            System.out.println("Received and sent an updated packet");
            System.out.println(playerPacket.point);
            System.out.println(playerPacket.name);
            System.out.println(SharedData.names[c.getID()]);
            System.out.println(c.getID());
        }

    }

    public void disconnected(Connection c) {

        //Removes a player from the map
        players.remove(c.getID());
        //Makes a packet of the PacketRemovePlayer
        PlayerStats packet = new PlayerStats();
        //Gets ID
        packet.ID = c.getID();
        //Sends all a new list of connection names.
        server.sendToAllExceptTCP(c.getID(), packet);
        //Prints to server console
        System.out.println("Connection dropped.");
    }
}

