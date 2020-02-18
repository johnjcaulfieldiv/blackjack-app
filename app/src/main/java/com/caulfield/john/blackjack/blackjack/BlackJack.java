package com.caulfield.john.blackjack.blackjack;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    private final Deck deck;
    private final Hand player;
    private final Hand dealer;

    private TextView tv_dealer_val;
    private TextView tv_player_val;

    // temp
    private TextView tv_dealer_hand;
    private TextView tv_player_hand;
    private TextView tv_game_result;
    private Button btn_new_game;
    private Button btn_hit;
    private Button btn_stay;
    private ConstraintLayout layout;
    private Activity activity;
    private List<ImageView> playerImages;
    private List<ImageView> dealerImages;
    private int playerImageIndex;
    private int dealerImageIndex;

    private Context context;

    public BlackJack() {
        deck = new Deck();
        player = new Hand();
        dealer = new Hand();
        playerImages = new ArrayList<>();
        dealerImages = new ArrayList<>();
    }

    public BlackJack(TextView tv_dealer_val, TextView tv_player_val, TextView tv_dealer_hand, TextView tv_player_hand, TextView tv_game_result,
                     Button btn_hit, Button btn_stay, Button btn_new_game, ConstraintLayout layout, Context context, Activity activity,
                     ArrayList<ImageView> playerImages, ArrayList<ImageView> dealerImages) {
        this();
        this.tv_dealer_val = tv_dealer_val;
        this.tv_player_val = tv_player_val;
        this.tv_dealer_hand = tv_dealer_hand;
        this.tv_player_hand = tv_player_hand;
        this.tv_game_result = tv_game_result;
        this.btn_hit = btn_hit;
        this.btn_new_game = btn_new_game;
        this.btn_stay = btn_stay;
        this.layout = layout;
        this.context = context;
        this.activity = activity;
        this.playerImages = playerImages;
        this.dealerImages = dealerImages;
        playerImageIndex = 0;
        dealerImageIndex = 0;
    }

    public void clearUI() {
        tv_dealer_val.setText("0");
        tv_player_val.setText("0");
        tv_dealer_hand.setText("");
        tv_player_hand.setText("");
        tv_game_result.setVisibility(View.INVISIBLE);

        for (ImageView iv : playerImages) {
            iv.setVisibility(View.INVISIBLE);
        }
        playerImageIndex = 0;
        for (ImageView iv : dealerImages) {
            iv.setVisibility(View.INVISIBLE);
        }
        dealerImageIndex = 0;
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
        showPlayerCard(player.getTopCard());
        dealer.drawFrom(deck);
        showDealerCard(dealer.getTopCard());
        player.drawFrom(deck);
        showPlayerCard(player.getTopCard());
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
        showPlayerCard(player.getTopCard());
        updateUI();
        checkForGameOver();
    }

    public void stay() {
        dealer.drawFrom(deck);
        showDealerCard(dealer.getTopCard());
        if (player.getValue() <= 21) {
            while (dealer.getValue() < player.getValue()) {
                dealer.drawFrom(deck);
                showDealerCard(dealer.getTopCard());
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

    private void showPlayerCard(Card c) {
        ImageView cardImageView = playerImages.get(playerImageIndex++);
        cardImageView.setImageResource(c.getImageId());
        cardImageView.setVisibility(View.VISIBLE);
    }

    private void showDealerCard(Card c) {
        ImageView cardImageView = dealerImages.get(dealerImageIndex++);
        cardImageView.setImageResource(c.getImageId());
        cardImageView.setVisibility(View.VISIBLE);
    }
}
