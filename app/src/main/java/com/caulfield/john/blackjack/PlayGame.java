package com.caulfield.john.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.caulfield.john.blackjack.blackjack.BlackJack;

public class PlayGame extends AppCompatActivity {

    private TextView mDealerHandTV;
    private TextView mPlayerHandTV;
    private TextView mDealerValTV;
    private TextView mPlayerValTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        // find textviews
        mDealerHandTV = (TextView) findViewById(R.id.tv_dealer_hand);
        mPlayerHandTV = (TextView) findViewById(R.id.tv_player_hand);
        mDealerValTV  = (TextView) findViewById(R.id.tv_dealer_val);
        mPlayerValTV  = (TextView) findViewById(R.id.tv_player_val);

        // start a new game of blackjack
        BlackJack blackJack = new BlackJack(mDealerValTV, mPlayerValTV, mDealerHandTV, mPlayerHandTV);
        blackJack.startNewHand();
    }
}

