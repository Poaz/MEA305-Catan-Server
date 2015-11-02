package com.company;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerSock extends KeyAdapter {

    BufferedReader BR;
    boolean Running = true;
    Card card = new Card();
    //PlayerStats Player = new PlayerStats();

    public static ArrayList<Socket> SocketArray = new ArrayList<Socket>();
    //public static ArrayList<String> Users = new ArrayList<String>();
    public static ArrayList<PlayerStats> Players = new ArrayList<PlayerStats>();
    static int givenID = 100;


    //System.out.println(StudentList.get(0).getName()+", "+StudentList.get(0).getId());

    ServerSock() {

    }

    public void run() throws IOException {
        card.DevCard();
        System.out.println("Server started!");

        // Opens server socket on port 1337
        ServerSocket SRVSock = new ServerSocket(444);

        while (Running) {
            Socket sock = SRVSock.accept();
            SocketArray.add(sock);
            InputStreamReader IR = new InputStreamReader(sock.getInputStream());
            BR = new BufferedReader(IR);

            AddUserName(sock);

            System.out.println("Client is connected from: " + sock.getLocalAddress().getHostName());
            //Setting the message to a String and print
          //  String message = BR.readLine();
          //  System.out.println(message);

/*            if (message.equals("card")) {
                PrintStream PS = new PrintStream(sock.getOutputStream());
                PS.println(card.DrawDev());

            }
            // Message received - Going to Client
            if (message != null) {
                PrintStream PS = new PrintStream(sock.getOutputStream());
                PS.println("Message Received");

            }*/

        }
    }

    public static void AddUserName(Socket X) throws IOException {
        Scanner input = new Scanner(X.getInputStream());
        String userName = input.nextLine();
        String ID_ = input.nextLine();
        //Users.add(userName);
        PlayerStats tempplayer = new PlayerStats();
        tempplayer.setName(userName);
        tempplayer.setID(givenID);
        givenID++;
        Players.add(tempplayer);
        for (int i = 0; i < Players.size(); i++) {
            System.out.println(Players.get(i).Name);
            System.out.println(Players.get(i).ID);
        }




    /*    for(int i = 1; i <= ChatServer.SocketArray.size(); i++){
            Socket tmpSock = (Socket) ChatServer.SocketArray.get(i-1);
            PrintWriter out = new PrintWriter(tmpSock.getOutputStream());
            out.println("#" + Users);
            out.flush();
        }*/
    }





}

