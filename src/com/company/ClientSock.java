package com.company;

import java.io.*;
import java.net.*;


public class ClientSock {

    ClientSock(){

    }

    public static void main(String[] args) throws Exception {


        // Client TCP
        ClientSock client = new ClientSock();
        client.run();
    }

    public void run()throws Exception {

        Socket sock = new Socket("localhost",444);
        PrintStream PS = new PrintStream(sock.getOutputStream());
        PS.println("Hello, server!");

        InputStreamReader IR = new InputStreamReader(sock.getInputStream());
        BufferedReader BR = new BufferedReader(IR);

        String message = BR.readLine();
        System.out.println(message);

    }
}
