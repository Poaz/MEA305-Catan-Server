package com.company;

import java.io.*;
import java.net.*;


public class Main {

    static byte[] data = new byte[1024];

    public static void main(String[] args) {

        //Dice rolling
        Dice dice = new Dice();
        //Dice prints
        System.out.println("Dice 1 = " + dice.getDie1());
        System.out.println("Dice 2 = " + dice.getDie2());
        System.out.println("Total = " + dice.getTotal());

        // TCP Server side

        ServerSocket socket = null; // Set up receive socket
        try {
            ServerSocket socket = null;
            socket = new ServerSocket(3333);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataInputStream dIn = null;
        try {
            dIn = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean done = false;
        while(!done) {


                    try {
                        byte messageType = dIn.readByte();
                        switch (messageType) {
                            case 1: // Type A
                                System.out.println("Message A: " + dIn.readUTF());
                                break;
                            case 2: // Type B
                                System.out.println("Message B: " + dIn.readUTF());
                                break;
                            case 3: // Type C
                                System.out.println("Message C [1]: " + dIn.readUTF());
                                System.out.println("Message C [2]: " + dIn.readUTF());
                                break;
                                    default:
                                        done = true;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            try {
                dIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        }
    }

