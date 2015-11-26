package com.company;


public class ClientData {
    public String nsname;
    public int nspoint;
    public int nsknights_played;
    public int nslength_of_road;
    public int nsresources_on_hand;
    public boolean nslobbyReady;
    public String[] nstextPackage = new String[]{"", "", ""};
    public boolean nsTextSent;
    public int[] serializedHouse = new int[]{0,0};
    public boolean endTurn = false, diceRoll;

    public boolean gameEnded = false;
    public boolean[] playerturn = new boolean[]{false,false,false,false};
    public boolean gamestart =false;

    public ClientData() {
    }
}
