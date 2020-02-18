package com.caulfield.john.blackjack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.caulfield.john.blackjack.blackjack.BlackJack;

public class PlayGame extends AppCompatActivity {

    private BlackJack mBlackjack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        // start a new game of blackjack
        mBlackjack = new BlackJack(this);
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

