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
    ServerData data = new ServerData();



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
        p1 = new JLabel("1"); p1name = new JLabel(data.getNames()[0]); p1point= new JLabel(Integer.toString(data.getPoints()[0])); p1knights= new JLabel(Integer.toString(data.getKnightsPlayed()[0])); p1resource= new JLabel(Integer.toString(data.getResourcesOnHand()[0])); p1longestRoad= new JLabel(Integer.toString(data.getLongestRoad()[0]));
        p2 = new JLabel("2"); p2name = new JLabel(data.getNames()[1]); p2point= new JLabel(Integer.toString(data.getPoints()[1])); p2knights= new JLabel(Integer.toString(data.getKnightsPlayed()[1])); p2resource= new JLabel(Integer.toString(data.getResourcesOnHand()[1])); p2longestRoad= new JLabel(Integer.toString(data.getLongestRoad()[1]));
        p3 = new JLabel("3"); p3name = new JLabel(data.getNames()[2]); p3point= new JLabel(Integer.toString(data.getPoints()[2])); p3knights= new JLabel(Integer.toString(data.getKnightsPlayed()[2])); p3resource= new JLabel(Integer.toString(data.getResourcesOnHand()[2])); p3longestRoad= new JLabel(Integer.toString(data.getLongestRoad()[2]));
        p4 = new JLabel("1"); p4name = new JLabel(data.getNames()[3]); p4point= new JLabel(Integer.toString(data.getPoints()[3])); p4knights= new JLabel(Integer.toString(data.getKnightsPlayed()[3])); p4resource= new JLabel(Integer.toString(data.getResourcesOnHand()[3])); p4longestRoad= new JLabel(Integer.toString(data.getLongestRoad()[3]));

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

