package com.caulfield.john.blackjack.blackjack;

import android.widget.TextView;

public class BlackJack {
    private final Deck deck;
    private Deck discard;
    private final Hand player;
    private final Hand dealer;

    private TextView tv_dealer_val;
    private TextView tv_player_val;

    // temp
    private TextView tv_dealer_hand;
    private TextView tv_player_hand;

    public BlackJack() {
        deck = new Deck();
        player = new Hand();
        dealer = new Hand();
    }

    public BlackJack(TextView tv_dealer_val, TextView tv_player_val, TextView tv_dealer_hand, TextView tv_player_hand) {
        this();
        this.tv_dealer_val = tv_dealer_val;
        this.tv_player_val = tv_player_val;
        this.tv_dealer_hand = tv_dealer_hand;
        this.tv_player_hand = tv_player_hand;
    }

    public void clearUI() {
        tv_dealer_val.setText("0");
        tv_player_val.setText("0");
        tv_dealer_hand.setText("");
        tv_player_hand.setText("");
    }

    public void startNewHand() {
        drawAndAddToHandViewString(player, tv_player_hand);
        drawAndAddToHandViewString(dealer, tv_dealer_hand);
        drawAndAddToHandViewString(player, tv_player_hand);
        updateValueTVs();
    }

    private void updateValueTVs() {
        String dVal = String.valueOf(dealer.getValue());
        String pVal = String.valueOf(player.getValue());
        tv_player_val.setText(pVal);
        tv_dealer_val.setText(dVal);
    }

    private void drawAndAddToHandViewString(Hand h, TextView htv) {
        h.drawFrom(deck);
        htv.setText(h.toString());
    }
}
