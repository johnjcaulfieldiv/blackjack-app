package com.caulfield.john.blackjack.blackjack;

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
        shuffle();
    }

    /* leaves the deck empty */
    public Deck(String empty) {
        deck = new ArrayList<>();
        discard = new ArrayList<>();
    }

    public Card draw() {
        if (empty()) {
            while (discard.size() > 0) {
                deck.add(discard.get(discard.size()-1));
                discard.remove(discard.size()-1);
            }
            shuffle();
        }
        int top = deck.size()-1;
        Card topCard = deck.get(top);
        deck.remove(top);
        return topCard;
    }

    public void addCard(Card c) {
        deck.add(c);
    }

    public void addCardToDiscard(Card c) {
        discard.add(c);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public boolean empty() {
        return deck.size() == 0;
    }

    public Card getTopCard() {
        return deck.get(deck.size()-1);
    }

    protected ArrayList<Card> getCardsInDeck() {
        return deck;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : deck) {
            sb.append(c.getVal() + c.getSuit() + " ");
        }
        return sb.toString();
    }
}
