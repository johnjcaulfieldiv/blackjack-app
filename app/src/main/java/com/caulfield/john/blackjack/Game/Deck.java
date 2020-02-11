package com.caulfield.john.blackjack.Game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;

    /* create standard 52 card deck */
    public Deck() {
        deck = new ArrayList<>();
        discard = new ArrayList<>();
        // 13 vals
        for (int val = 1; val <= 13; ++val) {
            // clubs, diamonds, hearts, spades
            deck.add(new Card(val, "c"));
            deck.add(new Card(val, "d"));
            deck.add(new Card(val, "h"));
            deck.add(new Card(val, "s"));
        }
    }

    /* leaves the deck empty */
    public Deck(String empty) {
        deck = new ArrayList<>();
        discard = new ArrayList<>();
    }

    public Card draw() {
        int top = deck.size()-1;
        Card topCard = deck.get(top);
        deck.remove(top);
        return topCard;
    }

    public void addCard(Card c) {
        deck.add(c);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public boolean empty() {
        return deck.size() == 0;
    }
}
