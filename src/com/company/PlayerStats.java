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

    public PlayerStats(){

    }
}