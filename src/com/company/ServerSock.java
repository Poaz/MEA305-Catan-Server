package com.company;
import java.io.*;
import java.net.*;

public class ServerSock {

    ServerSock(){

    }

    public void run() throws IOException {

        // Opens server socket on port 444
        ServerSocket SRVSock = new ServerSocket(1337);

        //Setting the server socket to a socket
        Socket sock = SRVSock.accept();

        //InputStreamReader
        InputStreamReader IR = new InputStreamReader(sock.getInputStream());

        //BufferedReader
        BufferedReader BR = new BufferedReader(IR);


        //Setting the message to a String and print
        String message = BR.readLine();
        System.out.println(message);

        // Message received - Going to Client
        if(message != null) {
            PrintStream PS = new PrintStream(sock.getOutputStream());
            PS.println("Message Received");
        }

    }


}
