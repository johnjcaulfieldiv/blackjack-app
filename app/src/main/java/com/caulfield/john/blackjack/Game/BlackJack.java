package com.caulfield.john.blackjack.Game;

public class BlackJack {
    private Deck deck;
    private Hand player;
    private Hand dealer;

    public BlackJack() {
        deck = new Deck();
        player = new Hand();
        dealer = new Hand();
    }


}
