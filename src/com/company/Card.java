package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Dines on 27-10-2015.
 */
class Card {

    private final ArrayList<String> cards = new ArrayList<String>();

    /*
    public static void main(String[] args) {
        Card card = new Card();
        card.DevCard();

    }
    */
    public void Resources() {
        int wood;
        int ore;
        int wool;
        int grain;
        int brick;
    }

    public void DevCard() {
        for (int i = 0; i < 13; i++) {
            cards.add("1"); //Knight cards x 14
        }
        for (int j = 0; j < 1; j++) {
            cards.add("9");//Monopoly cards x 2
            cards.add("7");//Year of plenty x 2
            cards.add("8");//Build a road x 2
        }
        cards.add("4");//Marketplace x 1
        cards.add("2");//University x 1
        cards.add("5");//Parlament x 1
        cards.add("3");//Library x 1
        cards.add("6");//Cathedral x 1
        //System.out.println(cards.get(20)); //Checks if cards are there.
        Collections.shuffle(cards);
        /*for(int k = 0; k<20;k++){
            System.out.println(cards.get(k));
        }//Checks if cards get shuffled.*/

        //System.out.println(cards.get(20)); //Checks if cards are there.
    }

    public String DrawDev() {
        String a = cards.get(0);
        cards.remove(0);
        System.out.println(a);
        return a;
    }
}
