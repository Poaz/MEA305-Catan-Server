package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI implements ActionListener {

    private JFrame f;
    private JPanel p;
    private JButton b1, b2, b3, b4;
    private JLabel ab;
    private JLabel p1, p1name, p1connected, p1point, p1knights, p1resource, p1longestRoad, p1gameStarted;
    private JLabel p2, p2name, p2connected, p2point, p2knights, p2resource, p2longestRoad, p2gameStarted;
    private JLabel p3, p3name, p3connected, p3point, p3knights, p3resource, p3longestRoad, p3gameStarted;
    private JLabel p4, p4name, p4connected, p4point, p4knights, p4resource, p4longestRoad, p4gameStarted;
    //ServerSock server = new ServerSock();




    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();



    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public GUI() {
        Interface();
    }

    public void Interface() {

        f = new JFrame("Settlers of Catan");
        f.setVisible(true);
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        p = new JPanel(new GridBagLayout());
        p.setBackground(Color.GREEN);
        b1 = new JButton("Start info server");
        b2 = new JButton("Shutdown server");
        b3 = new JButton("");
        b4 = new JButton("");

        ab = new JLabel("Settlers of Catan");
        p1 = new JLabel(1), p1name = new JLabel(ServerData.names[0]), p1connected, p1point, p1knights, p1resource, p1longestRoad, p1gameStarted;
        p2 = new JLabel(1), p2name = new JLabel(ServerData.names[1]), p2connected, p2point, p2knights, p2resource, p2longestRoad, p2gameStarted;
        p3 = new JLabel(1), p3name = new JLabel(ServerData.names[2]), p3connected, p3point, p3knights, p3resource, p3longestRoad, p3gameStarted;
        p4 = new JLabel(1), p4name = new JLabel(ServerData.names[3]), p4connected, p4point, p4knights, p4resource, p4longestRoad, p4gameStarted;

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

