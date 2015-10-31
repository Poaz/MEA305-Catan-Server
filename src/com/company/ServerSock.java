package com.company;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;

public class ServerSock extends KeyAdapter {

    BufferedReader BR;
    Socket sock;
    boolean Running = true;
    Card card = new Card();
    ServerSock() {

    }

    public void run() throws IOException {
        card.DevCard();
        System.out.println("Server started!");

        // Opens server socket on port 1337
        ServerSocket SRVSock = new ServerSocket(444);

        //Setting the server socket to a socket
        sock = SRVSock.accept();

        //InputStreamReader
        InputStreamReader IR = new InputStreamReader(sock.getInputStream());

        //BufferedReader
        BR = new BufferedReader(IR);

        while (Running) {

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

