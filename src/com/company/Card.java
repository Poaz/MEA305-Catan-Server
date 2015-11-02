package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Dines on 27-10-2015.
 */
public class Card {

    ArrayList<String> cards = new ArrayList<String>();

    public static void main(String[] args) {
        Card card = new Card();
        card.DevCard();

    }

    public void Resources() {
        int wood;
        int ore;
        int wool;
        int grain;
        int brick;
    }

    public void DevCard() {
        for (int i = 0; i < 13; i++) {
            cards.add("soldier");
        }
        for (int j = 0; j < 1; j++) {
            cards.add("progressM");
            cards.add("progressF");
            cards.add("progressB");
        }
        cards.add("vPMarkedplace");
        cards.add("vPUniversity");
        cards.add("vPParlament");
        cards.add("vPLibrary");
        cards.add("vPCatherdral");
        //System.out.println(cards.get(20)); //Checks if cards are there.
        Collections.shuffle(cards);
        /*for(int k = 0; k<20;k++){
            System.out.println(cards.get(k));
        }//Checks if cards get shuffled.*/

        System.out.println(cards.get(20)); //Checks if cards are there.
    }

    public String DrawDev() {
        String a = cards.get(0);
        cards.remove(0);
        System.out.println(a);
        return a;
    }
}
