package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dines on 27-10-2015.
 */
/*public class ChatServer {

    public static ArrayList<Socket> SocketArray = new ArrayList<Socket>();
    public static ArrayList<String> Users = new ArrayList<String>();

    public static void chat() throws Exception {

        final int port = 1337;
        ServerSocket chatSocket = new ServerSocket(port);
        System.out.println("Waiting for clients to connect");

        while(true){
            Socket sock = chatSocket.accept();
            SocketArray.add(sock);

            System.out.println("Client is connected from: " + sock.getLocalAddress().getHostName());

            AddUserName(sock);

            //ChatServerReturn chat = new ChatServerReturn(sock);
            //Thread x = new Thread(chat);
            //x.start();
        }
    }

    public static void AddUserName(Socket X) throws Exception {
        Scanner input = new Scanner(X.getInputStream());
        String userName = input.nextLine();
        Users.add(userName);

        for(int i = 1; i <= ChatServer.SocketArray.size(); i++){
            Socket tmpSock = (Socket) ChatServer.SocketArray.get(i-1);
            PrintWriter out = new PrintWriter(tmpSock.getOutputStream());
            out.println("#" + Users);
            out.flush();
        }
    }
    {

    }

}*/
