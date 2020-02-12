package com.caulfield.john.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* called when 'Play' button is pressed */
    public void playGame(View view) {
        Intent playGameIntent = new Intent(this, PlayGame.class);
        startActivity(playGameIntent);
    }
}
