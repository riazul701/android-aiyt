package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button loginButton, logoutButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.loginButtonId);
        logoutButton = (Button) findViewById(R.id.logoutButtonId);
        textView = (TextView) findViewById(R.id.textViewId);

        Handler handler = new Handler();

        loginButton.setOnClickListener(handler);
        logoutButton.setOnClickListener(handler);
    }

    class Handler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.loginButtonId) {
                textView.setText("Login button is clicked");
            } else if (v.getId() == R.id.logoutButtonId) {
                textView.setText("Logout button is clicked");
            }
        }
    }


}
