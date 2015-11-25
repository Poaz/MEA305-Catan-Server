package com.company;

import javax.swing.*;
import java.awt.*;

public class GuiServer extends JFrame {
    JLabel p1, p1name, p1connected, p1point, p1knights, p1resource, p1longestRoad, p1gameStarted;
    JLabel p2, p2name, p2connected, p2point, p2knights, p2resource, p2longestRoad, p2gameStarted;
    JLabel p3, p3name, p3connected, p3point, p3knights, p3resource, p3longestRoad, p3gameStarted;
    JLabel p4, p4name, p4connected, p4point, p4knights, p4resource, p4longestRoad, p4gameStarted;
    JLabel playerNumber,names,points,knightsOnHand,resourcesOnHand,longestRoad;
    boolean hasRun = false;


    public GuiServer() {
    }

    ServerData data = new ServerData();
    public void update(String[] name, int[] point, int[] knightsPlayed, int[] resources, int[] longestRoads, int turn){

        setLayout(new GridLayout(6,4));
        playerNumber = new JLabel("Player number:");
        names = new JLabel("Names of Players:");
        points = new JLabel("Points:");
        knightsOnHand = new JLabel("Number of Knights on Hand:");
        resourcesOnHand = new JLabel("Number of Resources on Hand:");
        longestRoad = new JLabel("Number of Roads Connected:");
        p1 = new JLabel("1");
        p1name = new JLabel(name[0]);
        p1point = new JLabel(Integer.toString(point[0]));
        p1knights = new JLabel(Integer.toString(knightsPlayed[0]));
        p1resource = new JLabel(Integer.toString(resources[0]));
        p1longestRoad = new JLabel(Integer.toString(longestRoads[0]));
        p1gameStarted = new JLabel(Integer.toString(turn));
        p2 = new JLabel("2");
        p2name= new JLabel(name[1]);
        p2point = new JLabel(Integer.toString(point[1]));
        p2knights = new JLabel(Integer.toString(knightsPlayed[1]));
        p2resource = new JLabel(Integer.toString(resources[1]));
        p2longestRoad = new JLabel(Integer.toString(longestRoads[1]));
        p2gameStarted = new JLabel(Integer.toString(turn));
        p3 = new JLabel("3");
        p3name = new JLabel(name[2]);
        p3point = new JLabel(Integer.toString(point[2]));
        p3knights = new JLabel(Integer.toString(knightsPlayed[2]));
        p3resource = new JLabel(Integer.toString(resources[2]));
        p3longestRoad = new JLabel(Integer.toString(longestRoads[2]));
        p3gameStarted = new JLabel(Integer.toString(turn));
        p4 = new JLabel("4");
        p4name = new JLabel(name[3]);
        p4point = new JLabel(Integer.toString(point[3]));
        p4knights = new JLabel(Integer.toString(knightsPlayed[3]));
        p4resource = new JLabel(Integer.toString(resources[3]));
        p4longestRoad = new JLabel(Integer.toString(longestRoads[3]));
        p4gameStarted = new JLabel(Integer.toString(turn));

        JLabel[] labelData ={
                playerNumber, p1, p2, p3, p4,
                names, p1name, p2name, p3name, p4name,
                points, p1point, p2point, p3point, p4point,
                knightsOnHand, p1knights, p2knights, p3knights, p4knights,
                resourcesOnHand, p1resource, p2resource, p3resource, p4resource,
                longestRoad, p1longestRoad, p2longestRoad, p3longestRoad, p4longestRoad,
        };

        if(!hasRun){
            for(int i = 0; i<labelData.length; i++) {
                add(labelData[i]);
            }

            hasRun = true;
        }
        repaint();
    }
}