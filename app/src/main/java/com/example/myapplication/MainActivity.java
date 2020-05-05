package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    }

    public void showMessage(View v) {
        if (v.getId() == R.id.loginButtonId) {
//            Toast.makeText(MainActivity.this,"Login Button is clicked",Toast.LENGTH_SHORT).show();
            Toast toast = Toast.makeText(MainActivity.this, "Login Button is clicked", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else if (v.getId() == R.id.logoutButtonId) {
//            Toast.makeText(MainActivity.this,"Logout Button is clicked",Toast.LENGTH_SHORT).show();
            Toast toast = Toast.makeText(MainActivity.this, "Logout Button is clicked", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }


}
