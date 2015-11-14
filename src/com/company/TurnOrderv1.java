package com.company;

/**
 * Created by AndreasKjong on 02-11-2015.
 */
class TurnOrderv1 {
    //int[] cPRessources;
    //int[] tPRessources;
    public static int turn = 0;
    public static int newTurn = 1;

    public static int switchPlayer(int currentPlayer/*, boolean[] playerList*/) {
        //new version of switchPlayer
        if (currentPlayer < 4) {
            currentPlayer++;
            return currentPlayer;
        } else {
            currentPlayer = 1;
            return currentPlayer;
        }
    }

    // if the current player + 1 = length (size) of array,
    // start back at the beginning and find the first player still playing
       /* if (currentPlayer + 1 == playerList.length) {
            for (int i = 0; i < playerList.length; i++) {
                if (playerList[i] == true) {    // if player is still in the game
                    currentPlayer = i;         // currentPlayer = current index of array
                    break;
                }
            }
        }
        // otherwise the current player number + 1 is not at the end of the array
        // i.e. it is less than the length (size) of the array, so find the next player
        // still playing
        else {
            for (int i = (currentPlayer + 1); i < playerList.length; i++) {
                if (playerList[i] == true) {
                    currentPlayer = i;
                    break;
                }
            }
        }
        return currentPlayer;
    }*/

    public void Trade(int currentPlayer, int tradingPlayer, int[] cPRessources, int[] tPRessources) {
        int[] cPres = new int[4];
        int[] tPres = new int[4];
        for (int i = 0; i < 4; i++) {
            cPres[i] = tPRessources[i];
            tPres[i] = cPRessources[i];
            cPRessources[i] = cPres[i];
            tPRessources[i] = tPres[i];
        }

    }
/*
    public String ReturnA() {
        String b = Arrays.toString(cPRessources);
        return b;
    }

    public String ReturnB() {
        String c = Arrays.toString(tPRessources);
        return c;
    }
*/

}
