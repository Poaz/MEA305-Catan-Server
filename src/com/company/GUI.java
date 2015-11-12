package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public abstract class GUI implements ActionListener {

    private JFrame f;
    private JPanel p;
    private JButton b1, b2, b3, b4;
    private JLabel ab;
    //ServerSock server = new ServerSock();

    public GUI() {
        Interface();
    }

    public void Interface() {

        f = new JFrame("Settlers of Catan");
        f.setVisible(true);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        p = new JPanel(new GridBagLayout());
        p.setBackground(Color.BLACK);
        b1 = new JButton("Start server");
        b2 = new JButton("Shutdown server");
        b3 = new JButton("");
        b4 = new JButton("");

        ab = new JLabel("Settlers of Catan");

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10, 10, 10, 10);

        c.gridx = 0;
        c.gridy = 10;
        p.add(b1, c);
        c.gridx = 0;
        c.gridy = 20;
        p.add(b2, c);
        c.gridx = 0;
        c.gridy = 30;
        p.add(b3, c);
        c.gridx = 0;
        c.gridy = 40;
        p.add(b4, c);
        c.gridx = 0;
        c.gridy = 0;
        p.add(ab, c);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

        }
    });

        f.add(p);

     }
    }

