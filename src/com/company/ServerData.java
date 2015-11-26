package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ServerData {

    public String[] names = new String[]{"", "", "", ""};
    public int[] points = new int[]{0, 0, 0, 0};
    public int[] knightsPlayed = new int[]{0, 0, 0, 0};
    public int[] resourcesOnHand = new int[]{0, 0, 0, 0};
    public boolean[] lobbyReadyAll = new boolean[]{false, false, false, false};
    public int longestRoad[] = new int[]{0, 0, 0, 0};
    public int turn, die1, die2, ID, cardID;
    public boolean StartGame = false;
    public String[] textToRender = new String[]{"", "", ""};
    public String[] oldText = new String[10];
    public ArrayList<Integer> cards = new ArrayList<Integer>();
    public int[] serializedHouse = new int[2];
    public boolean endTurn, diceRoll;

    public int turnorderturn = 1;
    public boolean gameEnded = false;
    public boolean[] playerturn = new boolean[]{false,false,false,false};
    public boolean gamestart =false;


    Integer[] yieldNumbers = {2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12};
    ArrayList<Integer> listOfYieldNumbers = new ArrayList<Integer>(Arrays.asList(yieldNumbers));
    ArrayList<String> listOfTileTypes = new ArrayList<String>(Arrays.<String>asList(
            "Grain", "Grain", "Grain", "Grain",
            "Lumber", "Lumber", "Lumber", "Lumber",
            "Wool", "Wool", "Wool", "Wool",
            "Ore", "Ore", "Ore",
            "Brick", "Brick", "Brick",
            "Desert"));

    public ServerData() {
    }

    public void TurnOrder() {

        while(!gameEnded) {
            if (turnorderturn == 1 && gamestart) {
                playerturn[0] = false;
                playerturn[1] = false;
                playerturn[2] = false;
                playerturn[3] = true;

                    if (endTurn && playerturn[3]) {
                        playerturn[0] = false;
                        playerturn[1] = false;
                        playerturn[2] = true;
                        playerturn[3] = false;
                        endTurn = false;
                    }
                    if (endTurn && playerturn[2]) {
                        playerturn[0] = false;
                        playerturn[1] = true;
                        playerturn[2] = false;
                        playerturn[3] = false;
                        endTurn = false;
                    }
                    if (endTurn && playerturn[1]) {
                        playerturn[0] = true;
                        playerturn[1] = false;
                        playerturn[2] = false;
                        playerturn[3] = false;
                        endTurn = false;
                    }
                    if(endTurn && playerturn[0]){
                        playerturn[0] = true;
                        playerturn[1] = false;
                        playerturn[2] = false;
                        playerturn[3] = false;
                        endTurn = false;
                        turnorderturn++;
                    }
            }

            if (turnorderturn == 2) {
                    if(endTurn && playerturn[0]){
                        playerturn[0] = false;
                        playerturn[1] = true;
                        playerturn[2] = false;
                        playerturn[3] = false;
                        endTurn = false;
                    }

                    if (endTurn && playerturn[1]) {
                        playerturn[0] = false;
                        playerturn[1] = false;
                        playerturn[2] = true;
                        playerturn[3] = false;
                        endTurn = false;
                    }
                    if (endTurn && playerturn[2]) {
                        playerturn[0] = false;
                        playerturn[1] = false;
                        playerturn[2] = false;
                        playerturn[3] = true;
                        endTurn = false;
                    }
                    if (endTurn && playerturn[3]) {
                        playerturn[0] = true;
                        playerturn[1] = false;
                        playerturn[2] = false;
                        playerturn[3] = false;
                        endTurn = false;
                    }
            }
        }

    }

    public void DevCard() {
        for (int i = 0; i < 13; i++) {
            cards.add(1); //Knight cards x 14
        }

        for (int j = 0; j < 1; j++) {
            cards.add(9);//Monopoly cards x 2
            cards.add(7);//Year of plenty x 2
            cards.add(8);//Build a road x 2
        }
        cards.add(4);//Marketplace x 1
        cards.add(2);//University x 1
        cards.add(5);//Parlament x 1
        cards.add(3);//Library x 1
        cards.add(6);//Cathedral x 1

        Collections.shuffle(cards);
    }

    public void DrawDev() {
        cardID = cards.get(0);
        cards.remove(0);
    }

    public void roll() {

        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
    }

    public void ShuffleMap() {
        Collections.shuffle(listOfYieldNumbers);
        Collections.shuffle(listOfTileTypes);
    }

    public void CheckLobbyReady() {
        if (lobbyReadyAll[0] && lobbyReadyAll[1] && lobbyReadyAll[2] && lobbyReadyAll[3]) {
            StartGame = true;
        }
    }

    public void updateOldMessages() {
        if (textToRender[1] == "") { //If there was one line of text..
            for (int i = oldText.length - 1; i > 0; i--) {
                oldText[i] = oldText[i - 1];
            }

            oldText[0] = textToRender[0];

        } else if (textToRender[1] != "" && textToRender[2] == "") { // If there was two lines of text..
            for (int i = oldText.length - 1; i > 1; i--) {
                oldText[i] = oldText[i - 2];
            }

            oldText[1] = textToRender[0];
            oldText[0] = textToRender[1];

        } else if (textToRender[2] != "") { // If there was three lines of text..

            for (int i = oldText.length - 1; i > 2; i--) {
                oldText[i] = oldText[i - 3];
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

