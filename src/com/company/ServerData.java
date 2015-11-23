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
    }

