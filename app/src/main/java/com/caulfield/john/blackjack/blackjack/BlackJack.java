package com.caulfield.john.blackjack.blackjack;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.caulfield.john.blackjack.R;

public class BlackJack {
    private final Deck deck;
    private final Hand player;
    private final Hand dealer;

    // Application reference
    private AppCompatActivity application;

    // UI
    private Context context;
        // TextViews
    private TextView tv_dealer_val;
    private TextView tv_player_val;
    private TextView tv_dealer_hand;
    private TextView tv_player_hand;
    private TextView tv_game_result;
        // Buttons
    private Button btn_new_game;
    private Button btn_hit;
    private Button btn_stay;
        // Layouts for card images
    private LinearLayout playerLayout;
    private LinearLayout dealerLayout;

    public BlackJack() {
        deck = new Deck();
        player = new Hand();
        dealer = new Hand();
    }

    public BlackJack(AppCompatActivity application) {
        this();
        this.application = application;
        this.context = application;
        this.tv_dealer_val = application.findViewById(R.id.tv_dealer_val);
        this.tv_player_val = application.findViewById(R.id.tv_player_val);
        this.tv_dealer_hand = application.findViewById(R.id.tv_dealer_hand);
        this.tv_player_hand = application.findViewById(R.id.tv_player_hand);
        this.tv_game_result = application.findViewById(R.id.tv_game_result);
        this.btn_new_game = application.findViewById(R.id.btn_play_again);
        this.btn_hit = application.findViewById(R.id.btn_hit);
        this.btn_stay = application.findViewById(R.id.btn_stay);
        this.dealerLayout = application.findViewById(R.id.layout_blackjack_dealer_linear_layout);
        this.playerLayout = application.findViewById(R.id.layout_blackjack_player_linear_layout);
    }

    public void clearUI() {
        tv_dealer_val.setText("0");
        tv_player_val.setText("0");
        tv_dealer_hand.setText("");
        tv_player_hand.setText("");
        tv_game_result.setVisibility(View.INVISIBLE);

        playerLayout.removeAllViews();
        dealerLayout.removeAllViews();
    }

    private void disableButton(Button b) {
        b.setVisibility(View.INVISIBLE);
        b.setEnabled(false);
    }

    private void enableButton(Button b) {
        b.setVisibility(View.VISIBLE);
        b.setEnabled(true);
    }

    public void startNewHand() {
        disableButton(btn_new_game);
        enableButton(btn_hit);
        enableButton(btn_stay);
        clearUI();
        player.drawFrom(deck);
        addCardImageToLayout(player.getTopCard(), playerLayout);
        dealer.drawFrom(deck);
        addCardImageToLayout(dealer.getTopCard(), dealerLayout);
        player.drawFrom(deck);
        addCardImageToLayout(player.getTopCard(), playerLayout);
        updateUI();
        checkForGameOver();
    }

    private void updateUI() {
        String dVal = String.valueOf(dealer.getValue());
        String pVal = String.valueOf(player.getValue());
        tv_player_val.setText(pVal);
        tv_dealer_val.setText(dVal);

        String dHand = dealer.toString();
        String pHand = player.toString();
        tv_dealer_hand.setText(dHand);
        tv_player_hand.setText(pHand);
    }

    private void checkForGameOver() {
        int pVal = player.getValue();
        int dVal = dealer.getValue();
        if (pVal == 21 && dVal == 21) {
            tv_game_result.setText("PUSH!");
        }
        else if (pVal == 21) {
            tv_game_result.setText("Blackjack!\nYou Win!");
        }
        else if (dVal == 21) {
            tv_game_result.setText("Dealer wins with 21!");
        }
        else if (pVal > 21) {
            tv_game_result.setText("Busted!");
        }
        else
            return;
        stay();
    }

    public void hit() {
        player.drawFrom(deck);
        addCardImageToLayout(player.getTopCard(), playerLayout);
        updateUI();
        checkForGameOver();
    }

    public void stay() {
        dealer.drawFrom(deck);
        addCardImageToLayout(dealer.getTopCard(), dealerLayout);
        if (player.getValue() <= 21) {
            while (dealer.getValue() < player.getValue()) {
                dealer.drawFrom(deck);
                addCardImageToLayout(dealer.getTopCard(), dealerLayout);
            }
        }
        endGame();
    }

    private void endGame() {
        updateUI();

        int pVal = player.getValue();
        int dVal = dealer.getValue();

        if (dVal > 21) {
            tv_game_result.setText("Dealer busts!\nYou win!");
        }
        else if (pVal > 21) {
            tv_game_result.setText("Busted!\nTry again");
        }
        else if (pVal > dVal) {
            tv_game_result.setText("You win!");
        }
        else if (pVal == dVal) {
            tv_game_result.setText("Push!");
        }
        else {
            tv_game_result.setText("Dealer takes this hand!");
        }

        tv_game_result.setVisibility(View.VISIBLE);

        disableButton(btn_hit);
        disableButton(btn_stay);
        enableButton(btn_new_game);

        player.discardHand(deck);
        dealer.discardHand(deck);
    }

    private void addCardImageToLayout(Card c, LinearLayout linearLayout) {
        ImageView cardImage = new ImageView(context);
        cardImage.setImageResource(c.getImageId());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.weight = 1.0f;
        params.width = 0;
        cardImage.setLayoutParams(params);
        linearLayout.addView(cardImage);
    }
}
