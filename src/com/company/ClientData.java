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
    public float[] serializedHouse = new float[]{0,0,0};

    public ClientData() {
    }
}
