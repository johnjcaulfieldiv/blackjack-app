package com.caulfield.john.blackjack;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.caulfield.john.blackjack.blackjack.BlackJack;

public class PlayGame extends AppCompatActivity {

    private BlackJack mBlackjack;
    private int mPlayersMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        // amount of money player has to bet in blackjack
        mPlayersMoney = 20;

        // start a new game of blackjack
        mBlackjack = new BlackJack(this, mPlayersMoney);
        mBlackjack.startNewHand();
    }

    /* called when 'Hit' button is pressed */
    public void onHitButtonClicked(View view) {
        mBlackjack.hit();
    }

    /* called when 'Stay' button is pressed */
    public void onStayButtonClicked(View view) {
        mBlackjack.stay();
    }

    /* called when 'Stay' button is pressed */
    public void onPlayAgainButtonClicked(View view) {
        mBlackjack.startNewHand();
    }
}

