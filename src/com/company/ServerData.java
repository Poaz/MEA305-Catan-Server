package com.company;

import com.esotericsoftware.kryonet.Connection;

public class ServerData {

    public String[] names = new String[]{"","","",""};
    public int[] points = new int[]{0,0,0,0};
    public int[] knightsPlayed = new int[]{0,0,0,0};
    public int[] resourcesOnHand = new int[]{0,0,0,0};
    public boolean[] lobbyReadyAll = new boolean[]{false,false,false,false};
    public int longestRoad[] = new int[]{0,0,0,0};
    public int turn;
    public boolean StartGame = false;
    public String[] textToRender = new String[]{"","",""};

    public ServerData(){

    }

    public void CheckLobbyReady() {

        if(lobbyReadyAll[0] && lobbyReadyAll[1] && lobbyReadyAll[2] && lobbyReadyAll[3]){
            StartGame = true;
        }

    }
}
