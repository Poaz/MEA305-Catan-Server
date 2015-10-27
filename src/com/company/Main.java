package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class Main {

    static byte[] data = new byte[1024];

    public static void main(String[] args)  {
        //UDP


        DatagramSocket sock = null;

        try {

            sock = new DatagramSocket(2000);

            while(true) {
                DatagramPacket pack = new DatagramPacket(data, 1024);
                sock.receive(pack);

                String receivedMessage = new String(pack.getData());


                if(receivedMessage.trim().equalsIgnoreCase("quit"));

                System.out.println(new String(pack.getData()));
                break;
            }

            sock.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //TCP
        //ServerSocket(2000);
        //accept();
        //getInputStream();


        //BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

    }

    private static void getInputStream() {
    }

    private static void accept() {
    }

    private static void ServerSocket(int i) {
    }
}
