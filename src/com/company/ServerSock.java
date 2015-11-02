package com.company;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServerSock extends KeyAdapter {

    BufferedReader BR;
    boolean Running = true;
    Card card = new Card();
    public static ArrayList<Socket> SocketArray = new ArrayList<Socket>();
    //public static ArrayList<String> Users = new ArrayList<String>();
    ServerSock() {

    }

    public void run() throws IOException {
        card.DevCard();
        System.out.println("Server started!");

        // Opens server socket on port 1337
        ServerSocket SRVSock = new ServerSocket(444);

        //Setting the server socket to a socket

        //Socket sock = SRVSock.accept();
       // ServerThread st=new ServerThread(sock);
        //st.start();
        //InputStreamRead



            //BufferedReader

            while (Running) {
                Socket sock = SRVSock.accept();
                SocketArray.add(sock);
                InputStreamReader IR = new InputStreamReader(sock.getInputStream());
                BR = new BufferedReader(IR);

                System.out.println("Client is connected from: " + sock.getLocalAddress().getHostName());
                //Setting the message to a String and print
                String message = BR.readLine();
                System.out.println(message);
                if (message.equals("card")) {
                    PrintStream PS = new PrintStream(sock.getOutputStream());
                    PS.println(card.DrawDev());

                }
                // Message received - Going to Client
                if (message != null) {
                    PrintStream PS = new PrintStream(sock.getOutputStream());
                    PS.println("Message Received");

                    }
        }


        }

}

