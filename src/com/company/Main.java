package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main extends JPanel{



    public static void main(String[] args) throws Exception {

        GUI gui = new GUI() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };

        //Playerstat creation
       // PlayerStats player1 = new PlayerStats(0,"Thomas");

        //Dice rolling
        Dice dice = new Dice();

        //Dice prints
        System.out.println("Dice 1 = " + dice.getDie1());
        System.out.println("Dice 2 = " + dice.getDie2());
        System.out.println("Total = " + dice.getTotal());


        while (true) {

            }
        }
    }



