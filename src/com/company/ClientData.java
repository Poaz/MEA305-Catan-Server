package com.company;


public class ClientData {
    public int nsID;
    public String nsname;
    public int nspoint;
    public int nsknights_played;
    public int nslength_of_road;
    public int nsresources_on_hand;
    public boolean nslobbyReady;
    public String[] nstextPackage = new String[]{"", "", ""};
    public boolean nsTextSent;
    public int[] serializedHouse = new int[2];
    public boolean endTurn, diceRoll;

    public boolean gameEnded = false;
    public boolean p1 = false;
    public boolean p2 = false;
    public boolean p3 = false;
    public boolean p4 = false;
    public boolean gamestart =false;

    public ClientData() {
    }
}
