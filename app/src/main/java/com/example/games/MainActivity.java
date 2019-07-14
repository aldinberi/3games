package com.example.games;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

   //beginning ofTicTacToe

    // yellow:0, red:1, empty:2
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameActive = true;
    int turnsLeft= 9;
    Fragment ticTacToe;
    public void dropIn(View view){

        TicTacToe.dropIn(view);

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

    public void playAgain(View view) {
        activePlayer=0;
        gameActive=true;
        turnsLeft= 9;
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        TextView playerTextView = findViewById(R.id.playerTextView);
        playerTextView.setText("It's Yellow's turn");
        playerTextView.setVisibility(View.VISIBLE);
        android.support.v7.widget.GridLayout gridLayout = (android.support.v7.widget.GridLayout)findViewById(R.id.TicTacToe);
        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
            gameState[i]=2;
        }
    }

    //End of TicTacToe

    // Beginning of Brain Train App



    // End of Brain Game

    int randomN;

    public void generateNumber(){
        Random random = new Random();
        randomN = random.nextInt(20) +1;
    }

    public void guess(View view){

        EditText guess = findViewById(R.id.GuessEditText);
        int guessN = Integer.parseInt(guess.getText().toString());

        if(guess.getText().toString().isEmpty()){
            Toast.makeText(this, "You must enter a number", Toast.LENGTH_SHORT).show();
        }
        else if ( guessN > randomN ) {
            Toast.makeText(this, "The number is lower", Toast.LENGTH_SHORT).show();
        }
        else if ( guessN < randomN ){
            Toast.makeText(this, "The number is higher", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "You guessed the number, congratulations, try to " +
                    "guess the new number", Toast.LENGTH_SHORT).show();
            generateNumber();
        }


    }






    private ViewPager mViewPager;
    public void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TicTacToe());
        adapter.addFragment(new BrainTrain());
        adapter.addFragment(new GuessNumber());
        viewPager.setAdapter(adapter);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_TicTacToe:
                   mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_BrainGame:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_Guess:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ticTacToe = new TicTacToe();
        mViewPager = findViewById(R.id.viewPager);
        setupViewPager(mViewPager);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

}
