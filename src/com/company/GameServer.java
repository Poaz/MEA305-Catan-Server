package com.company;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class GameServer extends Listener {

    //Initializing Port and server.
    private static final int port = 23820;
    private static Server server;
    //Making a Server object.
    ServerData data = new ServerData();
    //Making a GUI object
    GuiServer GUI = new GuiServer();
    private boolean GameStarted = true;
    private boolean firstJoin = true;

    GameServer() {
    }

    public static void main(String[] args) throws IOException {
        //Initialize the server
        server = new Server(16384, 2048);

        //Classes that needs to be registered into KryoNet so they can be sent over Kryonet.
        server.getKryo().register(int[].class);
        server.getKryo().register(ServerData.class);
        server.getKryo().register(ClientData.class);
        server.getKryo().register(boolean[].class);
        server.getKryo().register(String[].class);
        server.getKryo().register(ArrayList.class);
        server.getKryo().register(Integer.class);
        server.getKryo().register(Integer[].class);

        //Binding the server port
        server.bind(port, port);

        //Start the server
        server.start();

        //Add a listener to the server
        server.addListener(new GameServer());
    }


    @Override
    public void connected(Connection c) {
        //Prints to server console [DEBUGGING]
        Log.set(Log.LEVEL_DEBUG);

        if(firstJoin){
            data.ShuffleMap();
            firstJoin = false;
            data.TurnOrder();
        }
        //Updating the newest player with the latest data, such as names and chat text.
        server.sendToAllTCP(data);
    }

    @Override
    public void received(Connection c, Object o) {
        data.CheckLobbyReady();
        data.TurnOrder();
        System.out.println(Arrays.toString(data.playerturn));

        if (o instanceof ClientData) {
            //Makes a packet of the ClientData class and sets it equal to the incoming object.
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
            //
            data.serializedHouse = playerPacket.serializedHouse;

            data.serializedRoad = playerPacket.serializedRoad;

            data.endTurn = playerPacket.endTurn;

            if(playerPacket.endTurn){
                data.TurnOrder();
            }

            //Checks if the received packet boolean is true.
            if (playerPacket.nsTextSent) {
                data.updateOldMessages();
            }
            //Chat text.
            data.textToRender = playerPacket.nstextPackage;

            if(playerPacket.diceRoll){
                data.roll();
                playerPacket.diceRoll = false;
                data.diceRoll = false;
                System.out.println(data.die1);
                System.out.println(data.die2);
            }

            //Sends out the data packet
            server.sendToAllTCP(data);

            //Prints to server console
            System.out.println("[Server]: Received a packet from ID: " + (c.getID() - 1));
            System.out.println("[Server]: ID: " + (c.getID() - 1) + " *** Points: " + data.points[c.getID() - 1]);
            System.out.println("[Server]: ID: " + (c.getID() - 1) + " *** Name: " + data.names[c.getID() - 1]);
            System.out.println("[Server]: ID: " + (c.getID() - 1) + " *** Ready: " + data.lobbyReadyAll[c.getID() - 1]);

            //Updates the server GUI with the newest stats.
            update();
        }

        if (data.StartGame && GameStarted) {
            data.gameStart = true;
            data.TurnOrder();
            server.sendToAllTCP(data);
            GameStarted = false;
        }
    }

    @Override
    public void disconnected(Connection c) {

    }

    public void update() {
        GUI.update(data.names, data.points, data.knightsPlayed, data.resourcesOnHand, data.longestRoad, data.playerturn);
        GUI.repaint();
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);
        GUI.setSize(1000, 200);
        GUI.setTitle("Gui Server");
    }
}

