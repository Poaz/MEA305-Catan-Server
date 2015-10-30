package com.company;

import javax.swing.*;
import java.io.*;
import java.net.*;


public class Main {



    public static void main(String[] args) throws Exception {

        //Dice rolling
        Dice dice = new Dice();
        //Dice prints
        System.out.println("Dice 1 = " + dice.getDie1());
        System.out.println("Dice 2 = " + dice.getDie2());
        System.out.println("Total = " + dice.getTotal());

        //Server TCP
        ServerSock server = new ServerSock();
        server.run();

        //Key listener for server shutdown
        JTextField component = new JTextField();
        component.addKeyListener(new ClientSock());

        }
    }

