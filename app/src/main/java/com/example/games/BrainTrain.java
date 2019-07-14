package com.example.games;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class BrainTrain extends Fragment {
    private Random rand = new Random();
    private TextView timer;
    private TextView score;
    private TextView firstOption;
    private TextView secondOption;
    private TextView thirdOption;
    private TextView fourthOption;
    private TextView resultExpression;
    private TextView expression;
    private TextView go;
    private CountDownTimer countDownTimer;
    private ConstraintLayout gameLayout;
    private Button playAgainB;
    private int result;
    private int counterInt=0;
    private int scoreInt=0;
    private int timeLeft=30000;

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                String updatedCounter = String.format(Locale.getDefault(), "%02ds", seconds);
                timer.setText(updatedCounter);
            }

            @Override
            public void onFinish() {
                firstOption.setClickable(false);
                secondOption.setClickable(false);
                thirdOption.setClickable(false);
                fourthOption.setClickable(false);
                resultExpression.setText("Done!!");
                playAgainB.setVisibility(View.VISIBLE);
                timer.setText("0s");

            }
        }.start();
    }

    private void generate(){
        int firstNumber = rand.nextInt(30) + 1;
        int secondNumber = rand.nextInt(30) + 1;

        int setResult = rand.nextInt(4) + 1;
        int operator = rand.nextInt(3) + 1;

        counterInt++;

        if (operator == 1) {
            result = firstNumber + secondNumber;
            expression.setText(Integer.toString(firstNumber) + " + " + Integer.toString(secondNumber));
            if (firstOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(result));
                secondOption.setText(Integer.toString(rand.nextInt(200) + 1));
                thirdOption.setText(Integer.toString(rand.nextInt(200) + 1));
                fourthOption.setText(Integer.toString(rand.nextInt(200) + 1));
            } else if (secondOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(rand.nextInt(2000) + 1));
                secondOption.setText(Integer.toString(result));
                thirdOption.setText(Integer.toString(rand.nextInt(200) + 1));
                fourthOption.setText(Integer.toString(rand.nextInt(200) + 1));
            } else if (thirdOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(rand.nextInt(200) + 1));
                secondOption.setText(Integer.toString(rand.nextInt(200) + 1));
                thirdOption.setText(Integer.toString(result));
                fourthOption.setText(Integer.toString(rand.nextInt(200) + 1));
            } else if (fourthOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(rand.nextInt(200) + 1));
                secondOption.setText(Integer.toString(rand.nextInt(200) + 1));
                thirdOption.setText(Integer.toString(rand.nextInt(200) + 1));
                fourthOption.setText(Integer.toString(result));
            }


        } else if (operator == 2) {
            result = firstNumber - secondNumber;
            expression.setText(Integer.toString(firstNumber) + " - " + Integer.toString(secondNumber));
            if (firstOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(result));
                secondOption.setText(Integer.toString(rand.nextInt(200) + 1));
                thirdOption.setText(Integer.toString(rand.nextInt(200) + 1));
                fourthOption.setText(Integer.toString(rand.nextInt(200) + 1));
            } else if (secondOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(rand.nextInt(200) + 1));
                secondOption.setText(Integer.toString(result));
                thirdOption.setText(Integer.toString(rand.nextInt(200) + 1));
                fourthOption.setText(Integer.toString(rand.nextInt(200) + 1));
            } else if (thirdOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(rand.nextInt(200) + 1));
                secondOption.setText(Integer.toString(rand.nextInt(200) + 1));
                thirdOption.setText(Integer.toString(result));
                fourthOption.setText(Integer.toString(rand.nextInt(200) + 1));
            } else if (fourthOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(rand.nextInt(200) + 1));
                secondOption.setText(Integer.toString(rand.nextInt(200) + 1));
                thirdOption.setText(Integer.toString(rand.nextInt(200) + 1));
                fourthOption.setText(Integer.toString(result));
            }


        } else if (operator == 3) {
            result = firstNumber * secondNumber;
            expression.setText(Integer.toString(firstNumber) + " * " + Integer.toString(secondNumber));
            if (firstOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(result));
                secondOption.setText(Integer.toString(rand.nextInt(200) + 1));
                thirdOption.setText(Integer.toString(rand.nextInt(200) + 1));
                fourthOption.setText(Integer.toString(rand.nextInt(200) + 1));
            } else if (secondOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(rand.nextInt(200) + 1));
                secondOption.setText(Integer.toString(result));
                thirdOption.setText(Integer.toString(rand.nextInt(200) + 1));
                fourthOption.setText(Integer.toString(rand.nextInt(200) + 1));
            } else if (thirdOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(rand.nextInt(200) + 1));
                secondOption.setText(Integer.toString(rand.nextInt(200) + 1));
                thirdOption.setText(Integer.toString(result));
                fourthOption.setText(Integer.toString(rand.nextInt(200) + 1));
            } else if (fourthOption.getTag().toString().equals(Integer.toString(setResult))) {
                firstOption.setText(Integer.toString(rand.nextInt(200) + 1));
                secondOption.setText(Integer.toString(rand.nextInt(200) + 1));
                thirdOption.setText(Integer.toString(rand.nextInt(200) + 1));
                fourthOption.setText(Integer.toString(result));
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.brain_train,container,false);

        timer=v.findViewById(R.id.textViewCounter);
        score=v.findViewById(R.id.textViewScore);
        firstOption=v.findViewById(R.id.textView1);
        secondOption=v.findViewById(R.id.textView2);
        thirdOption=v.findViewById(R.id.textView3);
        fourthOption=v.findViewById(R.id.textView4);
        expression=v.findViewById(R.id.expresionView);
        resultExpression=v.findViewById(R.id.textViewResult);
        go=v.findViewById(R.id.textViewGo);
        gameLayout=v.findViewById(R.id.gameLayout);
        playAgainB=v.findViewById(R.id.buttonPlayAgainB);

        playAgainB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate();
                firstOption.setClickable(true);
                secondOption.setClickable(true);
                thirdOption.setClickable(true);
                fourthOption.setClickable(true);
                startTimer();
                scoreInt=0;
                counterInt=0;
                score.setText("0/0");
                resultExpression.setText("");
                playAgainB.setVisibility(View.INVISIBLE);
            }
        });

        firstOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressedNumber = (TextView) v;
                int numberInView=Integer.parseInt(pressedNumber.getText().toString());
                if(numberInView==result){
                    scoreInt++;
                    resultExpression.setText("Correct :)");
                }else{
                    resultExpression.setText("Wrong :(");
                }
                score.setText(Integer.toString(scoreInt)+"/"+Integer.toString(counterInt));
                generate();
            }
        });

        secondOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressedNumber = (TextView) v;
                int numberInView=Integer.parseInt(pressedNumber.getText().toString());
                if(numberInView==result){
                    scoreInt++;
                    resultExpression.setText("Correct :)");
                }else{
                    resultExpression.setText("Wrong :(");
                }
                score.setText(Integer.toString(scoreInt)+"/"+Integer.toString(counterInt));
                generate();
            }
        });

        thirdOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressedNumber = (TextView) v;
                int numberInView=Integer.parseInt(pressedNumber.getText().toString());
                if(numberInView==result){
                    scoreInt++;
                    resultExpression.setText("Correct :)");
                }else{
                    resultExpression.setText("Wrong :(");
                }
                score.setText(Integer.toString(scoreInt)+"/"+Integer.toString(counterInt));
                generate();
            }
        });

        fourthOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pressedNumber = (TextView) v;
                int numberInView=Integer.parseInt(pressedNumber.getText().toString());
                if(numberInView==result){
                    scoreInt++;
                    resultExpression.setText("Correct :)");
                }else{
                    resultExpression.setText("Wrong :(");
                }
                score.setText(Integer.toString(scoreInt)+"/"+Integer.toString(counterInt));
                generate();
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate();
                go.setVisibility(View.INVISIBLE);
                gameLayout.setVisibility(View.VISIBLE);
                startTimer();
            }
        });

       return v;

    }
}

