package com.example.myapplication;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView strawberryImageView, orangeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strawberryImageView = (ImageView) findViewById(R.id.strawberryImageViewId);
        orangeImageView = (ImageView) findViewById(R.id.orangeImageViewId);

        strawberryImageView.setOnClickListener(this);
        orangeImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.strawberryImageViewId) {
            strawberryImageView.setVisibility(View.GONE);
            orangeImageView.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.orangeImageViewId) {
            orangeImageView.setVisibility(View.GONE);
            strawberryImageView.setVisibility(View.VISIBLE);
        }
    }
}
