package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    private TicTacToe ticTacToe;
    private Button playAgainButton;
    private Button homeButton;
    private TextView playerTurn;
    private String[] playerNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        playAgainButton = findViewById(R.id.playAgainButton);
        homeButton = findViewById(R.id.homeButton);
        playerTurn = findViewById(R.id.displayTurn);

        playAgainButton.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);

        ticTacToe = findViewById(R.id.TicTacToe);

        playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if (playerNames != null) {
            playerTurn.setText((playerNames[0] + " вводит"));
        }

        ticTacToe.setUpGame(playAgainButton, homeButton, playerTurn, playerNames);
    }

    public void playAgainPress(View view){
        ticTacToe.resetGame();
        ticTacToe.invalidate();
    }

    public void homePress(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}