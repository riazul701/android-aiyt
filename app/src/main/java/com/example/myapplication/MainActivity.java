package com.example.myapplication;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] countryNames;
    private int[] flags = {R.drawable.afghanistan,R.drawable.armenia,R.drawable.azerbaijan,R.drawable.bahrain,R.drawable.bangladesh,R.drawable.bhutan,R.drawable.china,R.drawable.india,R.drawable.japan,R.drawable.nepal,R.drawable.pakistan,R.drawable.sri_lanka};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_names);
        listView = (ListView) findViewById(R.id.listViewId);
        CustomAdapter adapter = new CustomAdapter(this,countryNames,flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value = countryNames[position];
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
