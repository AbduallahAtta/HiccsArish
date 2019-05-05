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
import butterknife.OnClick;

public class StudentActivity extends AppCompatActivity {

    @BindView(R.id.studentProfile)
    ImageView studentProfileImage;
    @BindView(R.id.galleryImageView)
    ImageView contactMailImage;
    @BindView(R.id.coursesTableImageView)
    ImageView coursesTableImage;
    @BindView(R.id.lastExamsImageView)
    ImageView lastExamsImage;
    @BindView(R.id.suggestImageView)
    ImageView suggestImage;
    @BindView(R.id.studentGradesImageView)
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

    @OnClick({R.id.studentProfile, R.id.contactMail, R.id.coursesTable, R.id.lastExams, R.id.suggest, R.id.studentGrades})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.studentProfile:
                startstudentProfileActivity();
                break;
            case R.id.contactMail:
                startcontactMailActivity();
                break;
            case R.id.coursesTable:
                startcoursesTableActivity();
                break;
            case R.id.lastExams:
                startlastExamsActivity();
                break;
            case R.id.suggest:
                startsuggestActivity();
                break;
            case R.id.studentGrades:
                startstudentGradesActivity();
                break;

        }
    }

    private void startstudentProfileActivity() {
        Intent intent = new Intent(this, StudentAccountActivity.class);
        startActivity(intent);
    }

    private void startcontactMailActivity() {
        Intent intent = new Intent(this, AcademicMailActivity.class);
        startActivity(intent);
    }

    private void startcoursesTableActivity() {
        Intent intent = new Intent(this, CoursesTableActivity.class);
        startActivity(intent);
    }

    private void startlastExamsActivity() {
        Intent intent = new Intent(this, CoursesTableActivity.class);
        startActivity(intent);
    }


    private void startstudentGradesActivity() {
        Intent intent = new Intent(this, StudentGradesActivity.class);
        startActivity(intent);
    }

    private void startsuggestActivity() {
        Intent intent = new Intent(this, SuggestionActivity.class);
        startActivity(intent);
    }


}
