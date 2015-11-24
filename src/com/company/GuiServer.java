package com.company;

import javax.swing.*;
import java.awt.*;

public class GuiServer extends JFrame {
    JLabel label1, label2, label3, label4, label5, label6;


    public GuiServer() {
        setLayout(new GridLayout(6,4));
        label1 = new JLabel("Label 1");
        add(label1);
        label2 = new JLabel("Label 1");
        add(label2);
        label3 = new JLabel("Label 1");
        add(label3);
        label4 = new JLabel("Label 1");
        add(label4);
        label5 = new JLabel("Label 1");
        add(label5);
        label6 = new JLabel("Label 1");
        add(label6);

    }

    public static void main(String args[]){
        GuiServer gui = new GuiServer();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(200,200);
        //gui.pack();
        gui.setTitle("Gui Server");
    }
}