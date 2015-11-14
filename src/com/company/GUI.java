package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class GUI implements ActionListener {

    //ServerSock server = new ServerSock();

    public GUI() {
        Interface();
    }

    private void Interface() {

        JFrame f = new JFrame("Settlers of Catan");
        f.setVisible(true);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(Color.BLACK);
        JButton b1 = new JButton("Start server");
        JButton b2 = new JButton("Shutdown server");
        JButton b3 = new JButton("");
        JButton b4 = new JButton("");

        JLabel ab = new JLabel("Settlers of Catan");

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

