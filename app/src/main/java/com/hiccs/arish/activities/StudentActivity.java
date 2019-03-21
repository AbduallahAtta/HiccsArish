package com.hiccs.arish.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hiccs.arish.R;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    public void StudentAccount(View view) {

        Intent i = new Intent(StudentActivity.this, StudentAccountActivity.class);
        startActivity(i);
    }

    public void inbox(View view) {
    }

    public void Courses_table(View view) {
    }

    public void previos_exams(View view) {
    }

    public void suggestion(View view) {
    }

    public void report(View view) {
    }
}
