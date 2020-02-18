package com.caulfield.john.blackjack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.caulfield.john.blackjack.blackjack.BlackJack;

public class PlayGame extends AppCompatActivity {

    private TextView mDealerHandTV;
    private TextView mPlayerHandTV;
    private TextView mDealerValTV;
    private TextView mPlayerValTV;
    private TextView mGameResultTV;

    private Button mStayButton;
    private Button mHitButton;
    private Button mPlayAgainButton;

    private BlackJack mBlackjack;

    private LinearLayout mPlayerLayout;
    private LinearLayout mDealerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        mDealerHandTV = (TextView) findViewById(R.id.tv_dealer_hand);
        mPlayerHandTV = (TextView) findViewById(R.id.tv_player_hand);
        mDealerValTV  = (TextView) findViewById(R.id.tv_dealer_val);
        mPlayerValTV  = (TextView) findViewById(R.id.tv_player_val);
        mGameResultTV = (TextView) findViewById(R.id.tv_game_result);

        mHitButton       = (Button) findViewById(R.id.btn_hit);
        mStayButton      = (Button) findViewById(R.id.btn_stay);
        mPlayAgainButton = (Button) findViewById(R.id.btn_play_again);

        mPlayerLayout = (LinearLayout) findViewById(R.id.layout_blackjack_player_linear_layout);
        mDealerLayout = (LinearLayout) findViewById(R.id.layout_blackjack_dealer_linear_layout);

        // start a new game of blackjack
        mBlackjack = new BlackJack(mDealerValTV, mPlayerValTV, mDealerHandTV, mPlayerHandTV, mGameResultTV,
                mHitButton, mStayButton, mPlayAgainButton, this, mPlayerLayout, mDealerLayout);
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

