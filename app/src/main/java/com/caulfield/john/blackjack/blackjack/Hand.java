package com.caulfield.john.blackjack.blackjack;

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
        switch (drawnValue) {
            case 1:
                value = 0;
                int aces = 0;
                for (Card c : cards.getCardsInDeck()) {
                    if (c.getVal() == 1)
                        aces += 1;
                    else
                        value += c.getVal();
                }
                if (value + 11 + aces-1 <= 21)
                    value += 11 + aces-1;
                else
                    value += aces;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                value += drawnValue;
                break;
            case 11:
            case 12:
            case 13:
                value += 10;
                break;
            default:
                break; // uh oh
        }
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

    @Override
    public String toString() {
        return cards.toString();
    }
}
