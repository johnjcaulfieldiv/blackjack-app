package com.caulfield.john.blackjack.Game;

public class Hand {
    private Deck cards;
    private int value;

    public Hand() {
        cards = new Deck("empty");
        value = 0;
    }

    public void drawFrom(Deck deckToDrawFrom) {
        cards.addCard(deckToDrawFrom.draw());
    }

    public void emptyHandToDeck(Deck deckToEmptyTo) {
        while (!cards.empty()) {
            deckToEmptyTo.addCard(cards.draw());
        }
    }

    public int getValue() {
        return value;
    }
}
