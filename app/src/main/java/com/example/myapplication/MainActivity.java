package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView scoreTextView;
    private Button increaseButton, decreaseButton;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = (TextView) findViewById(R.id.textViewId);
        increaseButton = (Button) findViewById(R.id.increaseScore);
        decreaseButton = (Button) findViewById(R.id.decreaseScore);

        if (loadScore() != 0) {
            scoreTextView.setText("Score : " + loadScore());
        }

        increaseButton.setOnClickListener(this);
        decreaseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.increaseScore) {
            score = score + 10;
            scoreTextView.setText("Score : " + score);
            saveScore(score);
        }
        if (view.getId() == R.id.decreaseScore) {
            score = score - 10;
            scoreTextView.setText("Score : " + score);
            saveScore(score);
        }
    }

    private void saveScore(int score) {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastScore", score);
        editor.commit();
    }

    private int loadScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("gameScore", Context.MODE_PRIVATE);
        int score = sharedPreferences.getInt("lastScore", 0);
        return score;
    }
}
