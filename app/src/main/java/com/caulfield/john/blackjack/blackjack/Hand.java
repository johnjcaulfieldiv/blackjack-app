package com.caulfield.john.blackjack.blackjack;

import com.caulfield.john.blackjack.PlayGame;

import static java.lang.Math.min;

public class Hand {
    private Deck cards;
    private int value;

    public Hand() {
        cards = new Deck("empty");
        value = 0;
    }

    public void drawFrom(Deck deckToDrawFrom) {
        cards.addCard(deckToDrawFrom.draw());
        Card drawn = cards.getTopCard();
        int drawnValue = drawn.getVal();
        if (drawnValue == 1)
            value = calculateHandValue(cards);
        else if (drawnValue < 11)
            value += drawnValue;
        else
            value += 10;
        if (value > 21)
            value = calculateHandValue(cards);
    }

    public void emptyHandToDeck(Deck deckToEmptyTo) {
        while (!cards.empty()) {
            deckToEmptyTo.addCard(cards.draw());
        }
        value = 0;
    }

    public void discardHand(Deck deckToEmptyTo) {
        while (!cards.empty()) {
            deckToEmptyTo.addCardToDiscard(cards.draw());
        }
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public int getSize() { return cards.getCardsInDeck().size(); }

    public Card getTopCard() {
        return cards.getTopCard();
    }

    private int calculateHandValue(Deck hand) {
        int handValue = 0;
        int aces = 0;
        for (Card c : hand.getCardsInDeck()) {
            if (c.getVal() == 1)
                aces += 1;
            else
                handValue += min(10, c.getVal());
        }
        if (handValue + 11 + aces-1 <= 21)
            handValue += 11 + aces-1;
        else
            handValue += aces;
        return handValue;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
