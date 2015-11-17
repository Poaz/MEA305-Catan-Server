package com.company;


import com.esotericsoftware.kryonet.Connection;

public class PlayerStats {

    public static int ID;
    public static String name = "";
    static int point = 0;
    static int knights_played = 0;
    static int length_of_road = 0;
    static int resources_on_hand = 0;
    public Connection c;
    public static int TEMPpoint=1;
    public static boolean lobbyReady = false;

    public int nsID;
    public String nsname;
    public int nspoint;
    public int nsknights_played;
    public int nslength_of_road;
    public int nsresources_on_hand;
    public boolean nslobbyReady;



    public PlayerStats(){

    }

    public void updateplayerstats(int additional_points, int additional_knights, int current_length_of_road, int current_resources_on_hand){
        point = point+additional_points;
        knights_played = knights_played+additional_knights;
        length_of_road= current_length_of_road;
        resources_on_hand = current_resources_on_hand;

    }

    public boolean checkpointstoseeifwin(){

        return false;
    }
    public static void update(){
        int nsID = ID;
        String nsname = name;
        int nspoint = point;
        int nsknights_played = knights_played;
        int nslength_of_road = length_of_road;
        int nsresources_on_hand = resources_on_hand;
        boolean nslobbyReady = lobbyReady;

    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }
}