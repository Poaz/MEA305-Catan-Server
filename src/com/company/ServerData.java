package com.company;

import java.util.*;

public class ServerData {

    public String[] names = new String[]{"","","",""};
    public int[] points = new int[]{0,0,0,0};
    public int[] knightsPlayed = new int[]{0,0,0,0};
    public int[] resourcesOnHand = new int[]{0,0,0,0};
    public boolean[] lobbyReadyAll = new boolean[]{false,false,false,false};
    public int longestRoad[] = new int[]{0,0,0,0};
    public int turn, dice1, dice2, ID, cardID;
    public boolean StartGame = false;
    public String[] textToRender = new String[]{"","",""};
    public String[] oldText = new String[10];

    Integer[] yieldNumbers = {2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12};
    ArrayList<Integer> listOfYieldNumbers = new ArrayList<Integer>(Arrays.asList(yieldNumbers));
    ArrayList<String> listOfTileTypes = new ArrayList<String>( Arrays.<String>asList(
                    "Grain", "Grain", "Grain", "Grain",
                    "Lumber", "Lumber", "Lumber", "Lumber",
                    "Wool", "Wool", "Wool", "Wool",
                    "Ore", "Ore", "Ore",
                    "Brick", "Brick", "Brick",
                    "Desert"));


    Card card = new Card();
    Dice dice = new Dice();

    public ServerData(){
    }

    public void ShuffleMap(){
        Collections.shuffle(listOfYieldNumbers);
        Collections.shuffle(listOfTileTypes);
    }

    public void CheckLobbyReady() {

        if (lobbyReadyAll[0] && lobbyReadyAll[1] && lobbyReadyAll[2] && lobbyReadyAll[3]) {
            ShuffleMap();
            StartGame = true;

        }
    }

    public void SetDice(){

        dice.roll();
        dice1 = dice.getDie1();
        dice2 = dice.getDie2();
    }

    public void SetCard(){
        cardID = card.DrawDev();
    }

    public void updateOldMessages(){
            if(textToRender[1] == ""){ //If there was one line of text..
                for (int i = oldText.length-1; i>0; i--){
                    oldText[i] = oldText[i-1];
                }

                oldText[0] = textToRender[0];

            } else if(textToRender[1] != "" && textToRender[2] == ""){ // If there was two lines of text..
                for (int i = oldText.length-1; i>1; i--){
                    oldText[i] = oldText[i-2];
                }

                oldText[1] = textToRender[0];
                oldText[0] = textToRender[1];

            } else if(textToRender[2] != ""){ // If there was three lines of text..

                for (int i = oldText.length-1; i>2; i--){
                    oldText[i] = oldText[i-3];
                }

                oldText[2] = textToRender[0];
                oldText[1] = textToRender[1];
                oldText[0] = textToRender[2];
            }
        }

    public String[] getNames() {
        return names;
    }
    public int[] getPoints() {
        return points;
    }
    public int[] getKnightsPlayed() {
        return knightsPlayed;
    }
    public int[] getResourcesOnHand() {
        return resourcesOnHand;
    }
    public boolean[] getLobbyReadyAll() {
        return lobbyReadyAll;
    }
    public int[] getLongestRoad() {
        return longestRoad;
    }
    public int getTurn() {
        return turn;
    }
    public boolean isStartGame() {
        return StartGame;
    }

}

