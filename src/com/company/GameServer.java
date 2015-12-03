package com.company;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

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

    //Method which runs everytime a new client connects
    @Override
    public void connected(Connection c) {
        //Prints to server console [DEBUGGING]
        Log.set(Log.LEVEL_DEBUG);

        //When the first player connects to the server, the map is shuffled, so when all the players is ready, the map will be showed.
        if(firstJoin){
            //runs the shuffle method
            data.ShuffleMap();
            //Updates the turnorder
            data.TurnOrder();
            firstJoin = false;
        }
        //Sends out
        server.sendToAllTCP(data);
    }

    //Method which receives all incoming traffic
    @Override
    public void received(Connection c, Object o) {
        //This method checks if all 4 players is ready in the lobby
        data.CheckLobbyReady();
        //Updates the turn order
        data.TurnOrder();

        //Checks if the incoming object is a instance of the ClientData class.
        if (o instanceof ClientData) {
            //Makes a packet of the ClientData class and sets it equal to the incoming object.
            ClientData playerPacket = (ClientData) o;
            //Adds name to the connection ID in a string array carrying all names.
            data.names[c.getID() - 1] = playerPacket.nsname;
            //Points acquired by each player.
            data.points[c.getID() - 1] = playerPacket.nspoint;
            //Addeding the dice rolled from the server to the statistics
            //Knights played by player, in an int array.
            data.knightsPlayed[c.getID() - 1] = playerPacket.nsknights_played;
            //Lobby Ready boolean array
            data.lobbyReadyAll[c.getID() - 1] = playerPacket.nslobbyReady;
            //Longest Road
            data.longestRoad[c.getID() - 1] = playerPacket.nslength_of_road;
            //Resources on hand.
            data.resourcesOnHand[c.getID() - 1] = playerPacket.nsresources_on_hand;
            //Sets the houses
            data.serializedHouse = playerPacket.serializedHouse;
            //Sets the roads
            data.serializedRoad = playerPacket.serializedRoad;
            //City
            data.serializedCity = playerPacket.serializedCity;
            //Sets the end turn boolean
            data.endTurn = playerPacket.endTurn;

            //If the end turn statement is true, the Turnorder is updated
            if(playerPacket.endTurn){
                data.TurnOrder();
            }

            //Checks if there should be a new trade
            if (playerPacket.tradingWithyou[4]){
                playerPacket.tradingWithyou[4] = false;
                data.tradingWithyou = playerPacket.tradingWithyou;
                int[] tmp_array = new int[10];
                for (int i = 0; i < 5; i++) {
                    tmp_array[i] = playerPacket.tradingResources[i+5];
                    tmp_array[i+5] = playerPacket.tradingResources[i];
                }
                data.tradingResources = tmp_array;
            }

            //Checks if the received packet boolean is true.
            if (playerPacket.nsTextSent) {
                //Updates the messages in the chat
                data.updateOldMessages();
            }
            //Chat text.
            data.textToRender = playerPacket.nstextPackage;

            //Checks if a client needs a new dice roll
            if(playerPacket.diceRoll){
                //Rolls the dices
                data.roll();
                //Sets the boolean diceroll to false in the incoming object
                playerPacket.diceRoll = false;
                playerPacket.diceUsed = false;
                //Sets the boolean diceroll to false, in the serverData.
                data.diceRoll = false;
                data.diceUsed = false;
            }
            if (playerPacket.diceUsed) {
                data.diceUsed = true;
                playerPacket.diceUsed = false;
            }
            //Sends out the data packet to all client via TCP
            server.sendToAllTCP(data);

            //Prints to server console
            //System.out.println("[Server]: Received a packet from ID: " + (c.getID() - 1));
            //System.out.println("[Server]: ID: " + (c.getID() - 1) + " *** Points: " + data.points[c.getID() - 1]);
            //System.out.println("[Server]: ID: " + (c.getID() - 1) + " *** Name: " + data.names[c.getID() - 1]);
            //System.out.println("[Server]: ID: " + (c.getID() - 1) + " *** Ready: " + data.lobbyReadyAll[c.getID() - 1]);

            //Updates the server GUI with the newest stats.
            update();
        }

        //An if statement that check if the game is ready to be started.
        if (data.StartGame && GameStarted) {
            //Sets gamestart to true.
            data.gameStart = true;
            //Updates the turnorder
            data.TurnOrder();
            //Sends out a packet to all via TCP
            server.sendToAllTCP(data);
            //Sets game started to false
            GameStarted = false;
        }
    }
    //Method which runs everytime a client disconnects.
    @Override
    public void disconnected(Connection c) {
        System.out.println(c.getID());
        c.close();
        System.out.println(c.getID());
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

