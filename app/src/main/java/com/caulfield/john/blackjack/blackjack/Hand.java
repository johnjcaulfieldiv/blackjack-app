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
                // TODO implement actual ace calculations for value
                if (value + 11 <= 21)
                    value += 11;
                else
                    value += 1;
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

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
