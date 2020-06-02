package com.example.myapplication;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String[] countryNames;
    private String[] population;
    private int[] flags = {R.drawable.afghanistan,R.drawable.bangladesh,R.drawable.india,R.drawable.bhutan,R.drawable.nepal,R.drawable.pakistan,R.drawable.japan,R.drawable.china,R.drawable.sri_lanka};
    private boolean isFirstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_name);
        population = getResources().getStringArray(R.array.population);
        spinner = (Spinner) findViewById(R.id.spinnerId);

        CustomAdapter customAdapter = new CustomAdapter(this,flags,countryNames,population);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(isFirstSelection == true) {
                    isFirstSelection = false;
                } else {
                    Toast.makeText(getApplicationContext(),countryNames[i]+" is selected",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
