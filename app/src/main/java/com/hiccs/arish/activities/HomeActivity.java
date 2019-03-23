package com.hiccs.arish.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hiccs.arish.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void student(View view) {
        Intent i = new Intent(HomeActivity.this, StudentActivity.class);
        startActivity(i);
    }

    public void Gallery(View view) {
        Intent i = new Intent(HomeActivity.this, GalleryActivity.class);
        startActivity(i);
    }

    public void staff(View view) {
        Intent i = new Intent(HomeActivity.this, StafffActivity.class);
        startActivity(i);
    }

    public void news(View view) {
        Intent i = new Intent(HomeActivity.this, NewsActivity.class);
        startActivity(i);
    }


    public void extra_courses(View view) {
        Intent i = new Intent(HomeActivity.this, ExtraCoursesActivity.class);
        startActivity(i);
    }

    public void infoo(View view) {
        Intent i = new Intent(HomeActivity.this, HicssInfoActivity.class);
        startActivity(i);
    }

    public void map(View view) {
        Intent i = new Intent(HomeActivity.this, MapsActivity.class);
        startActivity(i);
    }
}
