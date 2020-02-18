package com.caulfield.john.blackjack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.caulfield.john.blackjack.blackjack.BlackJack;

import java.util.ArrayList;

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

    private ConstraintLayout mBlackjackLayout;

    private ArrayList<ImageView> mPlayerCardImageList;
    private ArrayList<ImageView> mDealerCardImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        // find textviews
        mDealerHandTV = (TextView) findViewById(R.id.tv_dealer_hand);
        mPlayerHandTV = (TextView) findViewById(R.id.tv_player_hand);
        mDealerValTV  = (TextView) findViewById(R.id.tv_dealer_val);
        mPlayerValTV  = (TextView) findViewById(R.id.tv_player_val);
        mGameResultTV = (TextView) findViewById(R.id.tv_game_result);

        mHitButton       = (Button) findViewById(R.id.btn_hit);
        mStayButton      = (Button) findViewById(R.id.btn_stay);
        mPlayAgainButton = (Button) findViewById(R.id.btn_play_again);

        mBlackjackLayout = (ConstraintLayout) findViewById(R.id.layout_game_activity_layout);

        mPlayerCardImageList = new ArrayList<ImageView>();
        mPlayerCardImageList.add((ImageView)findViewById(R.id.iv_player1));
        mPlayerCardImageList.add((ImageView)findViewById(R.id.iv_player2));
        mPlayerCardImageList.add((ImageView)findViewById(R.id.iv_player3));
        mPlayerCardImageList.add((ImageView)findViewById(R.id.iv_player4));
        mPlayerCardImageList.add((ImageView)findViewById(R.id.iv_player5));
        mPlayerCardImageList.add((ImageView)findViewById(R.id.iv_player6));
        mPlayerCardImageList.add((ImageView)findViewById(R.id.iv_player7));
        mPlayerCardImageList.add((ImageView)findViewById(R.id.iv_player8));

        mDealerCardImageList = new ArrayList<ImageView>();
        mDealerCardImageList.add((ImageView)findViewById(R.id.iv_dealer1));
        mDealerCardImageList.add((ImageView)findViewById(R.id.iv_dealer2));
        mDealerCardImageList.add((ImageView)findViewById(R.id.iv_dealer3));
        mDealerCardImageList.add((ImageView)findViewById(R.id.iv_dealer4));
        mDealerCardImageList.add((ImageView)findViewById(R.id.iv_dealer5));
        mDealerCardImageList.add((ImageView)findViewById(R.id.iv_dealer6));
        mDealerCardImageList.add((ImageView)findViewById(R.id.iv_dealer7));
        mDealerCardImageList.add((ImageView)findViewById(R.id.iv_dealer8));


        // start a new game of blackjack
        mBlackjack = new BlackJack(mDealerValTV, mPlayerValTV, mDealerHandTV, mPlayerHandTV, mGameResultTV,
                mHitButton, mStayButton, mPlayAgainButton, mBlackjackLayout, this, this, mPlayerCardImageList, mDealerCardImageList);
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

