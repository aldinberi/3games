package com.example.games;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TicTacToe extends Fragment {

    public static void dropIn(View view){

        TextView playerTextView = findViewById(R.id.playerTextView);
        ImageView counter = (ImageView) view;
        Button playAgainButton = findViewById(R.id.playAgainButton);
        TextView winnerTextView = findViewById(R.id.winnerTextView);

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]== 2 && gameActive) {
            gameState[tappedCounter] = activePlayer;
            turnsLeft--;
            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            if(activePlayer ==0)
                playerTextView.setText("It's Yellow's turn");
            else
                playerTextView.setText("It's Red's turn");

            counter.animate().translationYBy(1500).setDuration(1000);

            for (int[] winningPositions : winningPositions) {
                if (gameState[winningPositions[0]] == gameState[winningPositions[1]] && gameState[winningPositions[1]] == gameState[winningPositions[2]] && gameState[winningPositions[0]] != 2) {
                    gameActive = false;
                    String winner = "";
                    if (activePlayer == 0)
                        winner = "Red";
                    else
                        winner = "Yellow";

                    winnerTextView.setText(winner + " has won");
                    gameActive=false;
                    playAgainButton.setVisibility(view.VISIBLE);
                    winnerTextView.setVisibility(view.VISIBLE);
                    playerTextView.setVisibility(view.INVISIBLE);
                }
            }

            if(turnsLeft==0 && gameActive==true){
                gameActive = false;

                winnerTextView.setText("It's a draw");

                playAgainButton.setVisibility(view.VISIBLE);
                winnerTextView.setVisibility(view.VISIBLE);
                playerTextView.setVisibility(view.INVISIBLE);
            }
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.tic_tac_toe,container,false);

        return v;

    }
}
