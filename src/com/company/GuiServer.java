package com.company;

import javax.swing.*;
import java.awt.*;

//Gui server class for displaying server data, transfers, player turn. Essentially a visual overview display of a consol.
public class GuiServer extends JFrame{
    //JLabels is a String label in the Swing library. JFrame uses Swing as well. The following JLabels is made in the constructor:
    JLabel p1, p1name, p1connected, p1point, p1knights, p1resource, p1longestRoad, p1gameStarted;
    JLabel p2, p2name, p2connected, p2point, p2knights, p2resource, p2longestRoad, p2gameStarted;
    JLabel p3, p3name, p3connected, p3point, p3knights, p3resource, p3longestRoad, p3gameStarted;
    JLabel p4, p4name, p4connected, p4point, p4knights, p4resource, p4longestRoad, p4gameStarted;
    JLabel playerNumber,names,points,knightsOnHand,resourcesOnHand,longestRoad,turnOrder;
    //boolean to ensure labelData array don't run again.
    boolean hasRun = false;


    public GuiServer() {
        //JLabels are instantiated.
        playerNumber = new JLabel();
        names = new JLabel();
        points = new JLabel();
        knightsOnHand = new JLabel();
        resourcesOnHand = new JLabel();
        longestRoad = new JLabel();
        turnOrder = new JLabel();
        p1 = new JLabel();
        p1name = new JLabel();
        p1point = new JLabel();
        p1knights = new JLabel();
        p1resource = new JLabel();
        p1longestRoad = new JLabel();
        p1gameStarted = new JLabel();
        p2 = new JLabel();
        p2name= new JLabel();
        p2point = new JLabel();
        p2knights = new JLabel();
        p2resource = new JLabel();
        p2longestRoad = new JLabel();
        p2gameStarted = new JLabel();
        p3 = new JLabel();
        p3name = new JLabel();
        p3point = new JLabel();
        p3knights = new JLabel();
        p3resource = new JLabel();
        p3longestRoad = new JLabel();
        p3gameStarted = new JLabel();
        p4 = new JLabel();
        p4name = new JLabel();
        p4point = new JLabel();
        p4knights = new JLabel();
        p4resource = new JLabel();
        p4longestRoad = new JLabel();
        p4gameStarted = new JLabel();
        //Window display set to exit on close, visible and defined size. Title of the window is set to Gui Server.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000,200);
        setTitle("Gui Server");
    }
    // Constructing a new ServerData() from the ServerData class.
    ServerData data = new ServerData();

    // paint from JFrame is used to display pixels generated, along with super.paint is rewriting new pixels.
    //The update is called in GameServer.
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void update(String player){

    }
    //update class of all displayed info gathered from the server using Kryo.
    public void update(String[] name, int[] point, int[] knightsPlayed, int[] resources, int[] longestRoads, boolean[] turn){
        //Gridlayout called, This is a function of Swing, generating a defined grid to fit JLabels and JButtons etc.
        setLayout(new GridLayout(7,4));
        //playerNumber = new JLabel("Player number:");
        //setText overwrites the JLabel or JButton.
        playerNumber.setText("Player Number:");
        names.setText("Names of Players:");
        points.setText("Points:");
        knightsOnHand.setText("Number of Knights on Hand:");
        resourcesOnHand.setText("Number of Resources on Hand:");
        longestRoad.setText("Number of Roads Connected:");
        turnOrder.setText("Turn Order");
        p1.setText("1");
        //array locations is used to structure player stats in the right way. Constructed in GameServer.
        //Integer.toString converts a non-String to String.
        p1name.setText(name[0]);
        p1point.setText(Integer.toString(point[0]));
        p1knights.setText(Integer.toString(knightsPlayed[0]));
        p1resource.setText(Integer.toString(resources[0]));
        p1longestRoad.setText(Integer.toString(longestRoads[0]));
        p1gameStarted.setText(Boolean.toString(turn[0]));
        p2.setText("2");
        p2name.setText(name[1]);
        p2point.setText(Integer.toString(point[1]));
        p2knights.setText(Integer.toString(knightsPlayed[1]));
        p2resource.setText(Integer.toString(resources[1]));
        p2longestRoad.setText(Integer.toString(longestRoads[1]));
        p2gameStarted.setText(Boolean.toString(turn[1]));
        p3.setText("3");
        p3name.setText(name[2]);
        p3point.setText(Integer.toString(point[2]));
        p3knights.setText(Integer.toString(knightsPlayed[2]));
        p3resource.setText(Integer.toString(resources[2]));
        p3longestRoad.setText(Integer.toString(longestRoads[2]));
        p3gameStarted.setText(Boolean.toString(turn[2]));
        p4.setText("4");
        p4name.setText(name[3]);
        p4point.setText(Integer.toString(point[3]));
        p4knights.setText(Integer.toString(knightsPlayed[3]));
        p4resource.setText(Integer.toString(resources[3]));
        p4longestRoad.setText(Integer.toString(longestRoads[3]));
        p4gameStarted.setText(Boolean.toString(turn[3]));
        //this.validate();
        //this.repaint();
        //JLabel[] is an array of all JLabels. This is used to easily add all JLabels to the gridLayout
        JLabel[] labelData ={
                playerNumber, p1, p2, p3, p4,
                names, p1name, p2name, p3name, p4name,
                points, p1point, p2point, p3point, p4point,
                knightsOnHand, p1knights, p2knights, p3knights, p4knights,
                resourcesOnHand, p1resource, p2resource, p3resource, p4resource,
                longestRoad, p1longestRoad, p2longestRoad, p3longestRoad, p4longestRoad,
                turnOrder, p1gameStarted, p2gameStarted, p3gameStarted, p4gameStarted,
        };
        //for loop adding the whole labelData array to gridLayout
        if(!hasRun){
            for(int i = 0; i<labelData.length; i++) {
                add(labelData[i]);
            }
        //only runs once when called from GameServer.
            hasRun = true;
        }


    }
}