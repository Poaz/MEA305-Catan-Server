package com.company;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameServer extends Listener {

    static final int port = 23820;
    static Server server;
    //Containing connections
    static Map<Integer, PlayerStats> players = new HashMap<Integer, PlayerStats>();

    public static void main(String[] args) throws IOException {
        //Playerstat creation
        // PlayerStats player1 = new PlayerStats(0,"Thomas");

        //Dice rolling
        //Dice dice = new Dice();

        //Dice prints
        //System.out.println("Dice 1 = " + dice.getDie1());
        //System.out.println("Dice 2 = " + dice.getDie2());
        //System.out.println("Total = " + dice.getTotal());

        //Initialize the server
        server = new Server();

        //Classes that needs to be registered into KryoNet so they can be sent.
        server.getKryo().register(PlayerStats.class);
        server.getKryo().register(Dice.class);

        //Binding the server port
        server.bind(port, port);

        //Start the server
        server.start();

        //Add a listener to the server
        server.addListener(new GameServer());

        //Prints to server console
        System.out.println("The server is ready");
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
    }

    public void received(Connection c, Object o){

        //If statements for setting the new values in the classes after the
        //Packets are received.
        if(o instanceof PlayerStats){
        //Makes a packet of the PacketAddPlayer and sets it equal to the incoming object.
            PlayerStats packet = (PlayerStats) o;


                //Sets the temp to the real class.
                players.get(c.getID()).point = packet.point;
                //Gets ID
                packet.point = ((PlayerStats) o).point;
                //Sends all a new list of connection names.
                server.sendToAllExceptUDP(c.getID(), packet);
                //Prints to server console
                System.out.println("received and sent an updated point packet");
                System.out.println(packet.point);


        }
    }

    public void disconnected (Connection c){

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

