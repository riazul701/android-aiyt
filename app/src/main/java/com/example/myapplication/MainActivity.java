package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView detailsTextView;
    private EditText usernameEditText, passwordEditText;
    private Button saveButton, loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailsTextView = (TextView) findViewById(R.id.detailsTextViewId);
        usernameEditText = (EditText) findViewById(R.id.usernameEditTextId);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextId);
        saveButton = (Button) findViewById(R.id.saveButtonId);
        loadButton = (Button) findViewById(R.id.loadButtonId);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.saveButtonId) {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (username.equals("") && password.equals("")) {
                Toast.makeText(getApplicationContext(), "Please enter some data", Toast.LENGTH_SHORT).show();
            } else {
                // Writing Data
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usernameKey", username);
                editor.putString("passwordKey", password);
                editor.commit();
                usernameEditText.setText("");
                passwordEditText.setText("");
                Toast.makeText(getApplicationContext(), "Data is stored successfully", Toast.LENGTH_SHORT).show();
            }
        }
        if (view.getId() == R.id.loadButtonId) {
// To read data
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
            if (sharedPreferences.contains("usernameKey") && sharedPreferences.contains("passwordKey")) {
                String username = sharedPreferences.getString("usernameKey", "Data Not Found");
                String password = sharedPreferences.getString("passwordKey", "Data Not Found");
                detailsTextView.setText(username + "\n" + password);
            }
        }
    }
}
