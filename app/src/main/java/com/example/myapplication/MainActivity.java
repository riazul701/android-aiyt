package com.example.myapplication;

//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentStatePagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pagerId);
        FragmentManager fragmentManager = getSupportFragmentManager();
        CustomAdapter adapter = new CustomAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
    }

    class CustomAdapter extends FragmentStatePagerAdapter {

        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0) {
                fragment = new FragmentOne();
            }
            else if (position == 1) {
                fragment = new FragmentTwo();
            }
            else if (position == 2) {
                fragment = new FragmentThree();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        public CharSequence getPageTitle(int position) {
            if(position == 0) {
                return "Tab1";
            }
            else if(position == 1) {
                return "Tab2";
            }
            if(position == 2) {
                return "Tab3";
            }
            return null;
        }
    }
}
