package com.company;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameServer extends Listener {

    //Initializing Port and server.
    private static final int port = 23820;
    private static Server server;

    //Containing connections in a HashMap.
    private static final Map<Integer, PlayerStats> players = new HashMap<Integer, PlayerStats>();

    //Making a Server object.
    ServerData data = new ServerData();

    public static void main(String[] args) throws IOException {
        //Initialize the server
        server = new Server(16384, 2048);

        //Classes that needs to be registered into KryoNet so they can be sent over Kryonet.
        server.getKryo().register(PlayerStats.class);
        server.getKryo().register(int[].class);
        server.getKryo().register(ServerData.class);
        server.getKryo().register(ClientData.class);
        server.getKryo().register(boolean[].class);
        server.getKryo().register(String[].class);

        //Binding the server port
        server.bind(port, port);

        //Start the server
        server.start();

        //Add a listener to the server
        server.addListener(new GameServer());
    }

    @Override
    public void connected(Connection c) {
        //Making a player object
        PlayerStats player = new PlayerStats();

        //Making a second player object
        PlayerStats packet = new PlayerStats();

        //Setting the ID in the PacketAddPlayer class to whatever ID comes from the connection.
        packet.ID = c.getID();

        //Sends all a new list of connection names.
        server.sendToAllExceptTCP(c.getID(), packet);

        //Sets players in player map.
        players.put(c.getID(), player);

        //Prints to server console [DEBUGGING]
        Log.set(Log.LEVEL_DEBUG);
    }


    @Override
    public void received(Connection c, Object o) {
            data.CheckLobbyReady();

        if (o instanceof ClientData) {
            //Makes a packet of the PacketAddPlayer and sets it equal to the incoming object.
            ClientData playerPacket = (ClientData) o;




            //Adds name to the connection ID in a string array carrying all names.
            data.names[c.getID() - 1] = playerPacket.nsname;
            //Points acquired by each player.
            data.points[c.getID() - 1] = playerPacket.nspoint;
            //Knights played by player, in an int array.
            data.knightsPlayed[c.getID() - 1] = playerPacket.nsknights_played;
            //Lobby Ready boolean array
            data.lobbyReadyAll[c.getID() - 1] = playerPacket.nslobbyReady;
            //Longest Road
            data.longestRoad[c.getID() - 1] = playerPacket.nslength_of_road;
            //Resources on hand.
            data.resourcesOnHand[c.getID() - 1] = playerPacket.nsresources_on_hand;
            //Turn order, determined by player ID
            //SharedData.turn = playerPacket.

            if(playerPacket.nsTextSent){
                data.updateOldMessages();
            }

            //Chat text.
            data.textToRender = playerPacket.nstextPackage;




           //players.get(c.getID()).points[c.getID()-1] = playerPacket.nspoint;

            //Sends out the data packet
            //server.sendToAllExceptTCP(c.getID(), data);
            //server.sendToAllUDP(data);
            server.sendToAllTCP(data);

            //Prints to server console
            System.out.println("[Server]: Received a packet from ID: " + (c.getID()-1));
            System.out.println("[Server]: ID: " + (c.getID()-1) + " *** Points: " + data.points[c.getID() - 1]);
            System.out.println("[Server]: ID: " + (c.getID()-1) + " *** Name: " + data.names[c.getID() - 1]);
            System.out.println("[Server]: ID: " + (c.getID()-1) + " *** Ready: " + data.lobbyReadyAll[c.getID()-1]);



        }


        if(data.StartGame){
            server.sendToAllExceptTCP(c.getID(), data);
            server.sendToAllTCP(data);
        }
    }

    @Override
    public void disconnected(Connection c) {
        //Removes a player from the map
        players.remove(c.getID());
        //Makes a packet of PlayerStats
        PlayerStats packet = new PlayerStats();
        //Gets ID
        packet.ID = c.getID();
        //Sends all a new list of connection names.
        server.sendToAllExceptTCP(c.getID(), packet);
        //Prints to server console
        //System.out.println("Connection dropped.");
    }
}

