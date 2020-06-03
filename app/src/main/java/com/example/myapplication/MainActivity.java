package com.example.myapplication;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewId);
        customAdapter = new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                String groupName = listDataHeader.get(i);
                Toast.makeText(getApplicationContext(),"group name : "+groupName,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int i) {
                String groupName = listDataHeader.get(i);
                Toast.makeText(getApplicationContext(),groupName+" is collapsed",Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String childString = listDataChild.get(listDataHeader.get(i)).get(i1);
                Toast.makeText(getApplicationContext(),childString,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandedPosition != -1 && lastExpandedPosition != i) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });

    }

    public void prepareListData() {


        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("1. Overview");
        listDataHeader.add("1. Environment setup");
        listDataHeader.add("1. Program structure");

        // Adding child data to the overview
        List<String> overView = new ArrayList<>();
        overView.add("1.1 What is C language");
        overView.add("1.2 History of C");
        overView.add("1.3 Features of C");
        overView.add("1.4 Advantages of C");

        // Adding child data to the environmentSetup
        List<String> environmentSetup = new ArrayList<>();
        environmentSetup.add("2.1 How to install codeblock");

        // Adding child data to the programStructure
        List<String> programStructure = new ArrayList<>();
        programStructure.add("3.1 program structure");


        listDataChild.put(listDataHeader.get(0),overView);
        listDataChild.put(listDataHeader.get(1),environmentSetup);
        listDataChild.put(listDataHeader.get(2),programStructure);
    }
}
