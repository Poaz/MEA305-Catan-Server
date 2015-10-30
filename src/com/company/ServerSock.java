package com.company;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;

public class ServerSock extends KeyAdapter {

    BufferedReader BR;
    Socket sock;
    boolean Running = true;

    ServerSock() {

    }

    public void run() throws IOException {

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

            // Message received - Going to Client
            if (message != null) {
                PrintStream PS = new PrintStream(sock.getOutputStream());
                PS.println("Message Received");
            }

            if (message == "quit") {
                Running = false;
            }
        }
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        }

        if (e.getKeyChar() == 'Q') {
            System.out.println("Check for key characters: " + e.getKeyChar());
        }
    }
}

