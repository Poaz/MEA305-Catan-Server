package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zilen on 03/11/2015.
 */
public class NewServerTry {

    //BufferedReader BR;
    //Scanner try2 = new Scanner(System.in);
    boolean Running = true;
    Card card = new Card();
    Scanner input;
    //PlayerStats Player = new PlayerStats();

    public static ArrayList<Socket> SocketArray = new ArrayList<Socket>();
    //public static ArrayList<String> Users = new ArrayList<String>();
    public static ArrayList<PlayerStats> Players = new ArrayList<PlayerStats>();
    static int givenID = 0;

    public static void main(String args[]){


        Socket sock=null;
        ServerSocket SRVSock=null;
        System.out.println("Server Listening......");
        try{
            SRVSock = new ServerSocket(4445);

        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Server error");

        }

        while(true){
            try{
                sock= SRVSock.accept();
                System.out.println("connection Established");
                //AddUserName(sock);
                ServerThread st=new ServerThread(sock);
                st.start();

            }

            catch(Exception e){
                e.printStackTrace();
                System.out.println("Connection Error");

            }
        }

    }
 /*   public static void AddUserName(Socket X) throws IOException {
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
            System.out.println("Player Name "+ Players.get(i).Name);
            System.out.println("Player ID " + Players.get(i).ID);
        }
    }*/

}

