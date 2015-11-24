package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.applet.Applet;

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

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
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

        ab = new JLabel("Settlers of Catan");
        p1 = new JLabel("1");
        p1name = new JLabel(data.getNames()[0]);
        p1point = new JLabel(Integer.toString(data.getPoints()[0]));
        p1knights = new JLabel(Integer.toString(data.getKnightsPlayed()[0]));
        p1resource = new JLabel(Integer.toString(data.getResourcesOnHand()[0]));
        p1longestRoad = new JLabel(Integer.toString(data.getLongestRoad()[0]));
        p1gameStarted = new JLabel(Integer.toString(data.getTurn()));
        p2 = new JLabel("2");
        p2name= new JLabel(data.getNames()[1]);
        p2point = new JLabel(Integer.toString(data.getPoints()[1]));
        p2knights = new JLabel(Integer.toString(data.getKnightsPlayed()[1]));
        p2resource = new JLabel(Integer.toString(data.getResourcesOnHand()[1]));
        p2longestRoad = new JLabel(Integer.toString(data.getLongestRoad()[1]));
        p2gameStarted = new JLabel(Integer.toString(data.getTurn()));
        p3 = new JLabel("3");
        p3name = new JLabel(data.getNames()[2]);
        p3point = new JLabel(Integer.toString(data.getPoints()[2]));
        p3knights = new JLabel(Integer.toString(data.getKnightsPlayed()[2]));
        p3resource = new JLabel(Integer.toString(data.getResourcesOnHand()[2]));
        p3longestRoad = new JLabel(Integer.toString(data.getLongestRoad()[2]));
        p3gameStarted = new JLabel(Integer.toString(data.getTurn()));
        p4 = new JLabel("4");
        p4name = new JLabel(data.getNames()[3]);
        p4point = new JLabel(Integer.toString(data.getPoints()[3]));
        p4knights = new JLabel(Integer.toString(data.getKnightsPlayed()[3]));
        p4resource = new JLabel(Integer.toString(data.getResourcesOnHand()[3]));
        p4longestRoad = new JLabel(Integer.toString(data.getLongestRoad()[3]));
        p4gameStarted = new JLabel(Integer.toString(data.getTurn()));


        f.add(p);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        button = new JButton("Button 1");
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Long-Named Button 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        pane.add(button, c);
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ServerGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}