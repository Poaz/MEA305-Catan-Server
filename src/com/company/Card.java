package com.company;

import java.util.ArrayList;
import java.util.Collections;

class Card {
    public ArrayList<Integer> cards = new ArrayList<Integer>();

  public Card(){
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

    public int DrawDev() {
        int a = cards.get(0);
        cards.remove(0);
        System.out.println(a);
        return a;
    }
}
