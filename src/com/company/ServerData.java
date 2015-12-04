package com.company;

import com.esotericsoftware.kryonet.Connection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//this class is the main part of the server. it takes all variations from the client, and sends it to all clients of the server
public class ServerData {

    //Variables for all clients, this is the variables that controls the clients data, and state of the game.
    public String[] names = new String[]{"", "", "", ""};
    public int[] points = new int[]{0, 0, 0, 0};
    public int[] knightsPlayed = new int[]{0, 0, 0, 0};
    public int[] resourcesOnHand = new int[]{0, 0, 0, 0};
    public boolean[] lobbyReadyAll = new boolean[]{false, false, false, false};
    public int longestRoad[] = new int[]{0, 0, 0, 0};
    public int turn, die1, die2, ID, cardID;
    public boolean StartGame = false, gameStart = false;
    public String[] textToRender = new String[]{"", "", ""};
    public String[] oldText = new String[10];
    public ArrayList<Integer> cards = new ArrayList<Integer>();
    public int[] serializedHouse = new int[]{0,0};
    public int[] serializedRoad = new int[] {0,0};
    public int serializedCity = 0;
    public int serializedThief = 0;
    public boolean endTurn = false, diceRoll;
    public boolean diceUsed = true;
    public int turnorderturn = 1;
    public boolean gameEnded = false;
    public boolean[] playerturn = new boolean[]{false, false, false, false};
    public Connection c;
    boolean first = true;
    public int[] rolledDiceStatistics = new int[]{0,0,0,0,0,0,0,0,0,0,0,0};
    public boolean sendTrade = false;
    public boolean resetTradingResources = true;
    public int[] resourcesTrade = new int[10];
    public int targetPlayerTrade;
    public boolean tradeResourcesToHandle = false;
    public boolean updateCard;
    public boolean isCardUpToDate;
    public boolean isNormalGameRound = false;

    Integer[] yieldNumbers = {2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12};
    ArrayList<Integer> listOfYieldNumbers = new ArrayList<Integer>(Arrays.asList(yieldNumbers));
    ArrayList<String> listOfTileTypes = new ArrayList<String>(Arrays.<String>asList(
            "Grain", "Grain", "Grain", "Grain",
            "Lumber", "Lumber", "Lumber", "Lumber",
            "Wool", "Wool", "Wool", "Wool",
            "Ore", "Ore", "Ore",
            "Brick", "Brick", "Brick",
            "Desert"));

    //constructor
    public ServerData() {
    }

    //figures whose turn it is to play
    public void TurnOrder() {

        //initially the game starts backwards. each player has a boolean attached, that changes accordingly
        //turnorderturn changes between 1 and 2. once the backwards round is done, the game can continue as normal (2)
        if (turnorderturn == 1 && gameStart && first) {

            playerturn[2] = false;
            playerturn[3] = true;
            turn = 3;
            first = false;
        }
        if (turnorderturn == 1) {
            if (endTurn && playerturn[3]) {
                playerturn[2] = true;
                playerturn[3] = false;
                turn = 2;
                endTurn = false;
            }
            if (endTurn && playerturn[2]) {
                playerturn[1] = true;
                playerturn[2] = false;
                turn = 1;
                endTurn = false;
            }
            if (endTurn && playerturn[1]) {
                playerturn[0] = true;
                playerturn[1] = false;
                turn = 0;
                endTurn = false;
            }
            if (endTurn && playerturn[0]) {
                playerturn[0] = true;
                turn = 0;
                endTurn = false;
                turnorderturn++;
            }
        }

        if (turnorderturn == 2) {
            if (endTurn && playerturn[0]) {
                playerturn[0] = false;
                playerturn[1] = true;
                turn = 1;
                endTurn = false;
            }

            if (endTurn && playerturn[1]) {
                playerturn[1] = false;
                playerturn[2] = true;
                turn = 2;
                endTurn = false;
            }
            if (endTurn && playerturn[2]) {
                playerturn[2] = false;
                playerturn[3] = true;
                turn = 3;
                endTurn = false;
            }
            if (endTurn && playerturn[3]) {
                playerturn[0] = true;
                turn = 0;
                playerturn[3] = false;
                endTurn = false;
                isNormalGameRound = true;
            }
        }
    }

    //Development cards. This method adds all the different development cards available in the game, and then shuffles the cards.
    public void DevCard() {
        System.out.println("Shuffling deck");
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

    //this method can be called by the client. if called, the program takes a card from the shuffled deck, and then
    public void DrawDev() {
        cardID = cards.get(0);
        cards.remove(0);
        //if we run out of development cards, we add a new deck and shuffle it
        if(cards.size() == 0){
            DevCard();
        }
    }

    //this method can be called by the client, everytime a client want's to roll the dice. when called, we call 2 random numbers between 1-6, and sends it to the client
    public void roll() {

        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
        rolledDiceStatistics[die1+die2-1]++;
    }

    ////this method is called at the start of the game, and shuffle's the map, so that all the yields spawn randomly, but same on each client
    public void ShuffleMap() {
        Collections.shuffle(listOfYieldNumbers);
        Collections.shuffle(listOfTileTypes);
    }

    //check whether the lobby is ready. only if all clients present have pressed ready, can the startgame boolean return true
    public void CheckLobbyReady() {
        if (lobbyReadyAll[0] && lobbyReadyAll[1] && lobbyReadyAll[2] && lobbyReadyAll[3]) {
            StartGame = true;
        }
    }

    //this is for the chat system, so it is always updated each if statement looks at how many lines that are created.
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
    //this renders the text in the client, so that every person can see what text has been written
            oldText[2] = textToRender[0];
            oldText[1] = textToRender[1];
            oldText[0] = textToRender[2];
        }
    }

    //calling trade
    public void trade(){

    }

    //get names of the different clients
    public String[] getNames() {
        return names;
    }

    //point update
    public int[] getPoints() {
        return points;
    }

    //amount of knights that each client has played
    public int[] getKnightsPlayed() {
        return knightsPlayed;
    }

    //how many resources the client has. if more than 7 when the thief is moved, you loose half
    public int[] getResourcesOnHand() {
        return resourcesOnHand;
    }

    //client can check who is ready
    public boolean[] getLobbyReadyAll() {
        return lobbyReadyAll;
    }

    //longest road. not working
    public int[] getLongestRoad() {
        return longestRoad;
    }

    //getting turn
    public int getTurn() {
        return turn;
    }

    //has the game started?
    public boolean isStartGame() {
        return StartGame;
    }

}

