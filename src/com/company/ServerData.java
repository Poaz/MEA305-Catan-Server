package com.company;


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
    public String[] oldText = new String[10];


    public ServerData(){

    }

    public void CheckLobbyReady() {

        if (lobbyReadyAll[0] && lobbyReadyAll[1] && lobbyReadyAll[2] && lobbyReadyAll[3]) {
            StartGame = true;
        }
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

    public void setNames(String[] names) {
        this.names = names;
    }

    public int[] getPoints() {
        return points;
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public int[] getKnightsPlayed() {
        return knightsPlayed;
    }

    public void setKnightsPlayed(int[] knightsPlayed) {
        this.knightsPlayed = knightsPlayed;
    }

    public int[] getResourcesOnHand() {
        return resourcesOnHand;
    }

    public void setResourcesOnHand(int[] resourcesOnHand) {
        this.resourcesOnHand = resourcesOnHand;
    }

    public boolean[] getLobbyReadyAll() {
        return lobbyReadyAll;
    }

    public void setLobbyReadyAll(boolean[] lobbyReadyAll) {
        this.lobbyReadyAll = lobbyReadyAll;
    }

    public int[] getLongestRoad() {
        return longestRoad;
    }

    public void setLongestRoad(int[] longestRoad) {
        this.longestRoad = longestRoad;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean isStartGame() {
        return StartGame;
    }

    public void setStartGame(boolean startGame) {
        StartGame = startGame;
    }
}

