package com.hiccs.arish.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.hiccs.arish.R;
import com.hiccs.arish.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentActivity extends AppCompatActivity {

    @BindView(R.id.studentProfileImage)
    ImageView studentProfileImage;
    @BindView(R.id.contactMailImage)
    ImageView contactMailImage;
    @BindView(R.id.coursesTableImage)
    ImageView coursesTableImage;
    @BindView(R.id.lastExamsImage)
    ImageView lastExamsImage;
    @BindView(R.id.suggestImage)
    ImageView suggestImage;
    @BindView(R.id.studentGradesImage)
    ImageView studentGradesImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ButterKnife.bind(this);
        loadImages();
    }

    private void loadImages() {
        Glide.with(this).load(Constants.STUDENT_PROFILE_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(studentProfileImage);
        Glide.with(this).load(Constants.STUDENT_MAIL_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(contactMailImage);
        Glide.with(this).load(Constants.STUDENT_COURSES_TABLE_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(coursesTableImage);
        Glide.with(this).load(Constants.STUDENT_LAST_EXAMS_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(lastExamsImage);
        Glide.with(this).load(Constants.STUDENT_SUGGESTION_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(suggestImage);
        Glide.with(this).load(Constants.STUDENT_GRADES_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(studentGradesImage);
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
