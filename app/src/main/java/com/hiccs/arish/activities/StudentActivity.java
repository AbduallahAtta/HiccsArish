package com.hiccs.arish.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.hiccs.arish.R;
import com.hiccs.arish.models.StudentAccountModel;
import com.hiccs.arish.models.news.News;
import com.hiccs.arish.utils.Constants;
import com.hiccs.arish.utils.StudentSharedPreferenceHelper;
import com.hiccs.arish.viewmodel.NewsViewModel;
import com.hiccs.arish.viewmodel.StudentProfileViewModel;
import com.hiccs.arish.viewmodel.StudentViewModelFactory;
import com.transitionseverywhere.TransitionManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

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
    @BindView(R.id.studentImageView)
    CircleImageView studentImageView;
    @BindView(R.id.hiccsNewsWidget)
    TextView hiccsNewsWidget;
    @BindView(R.id.greetingLabel)
    TextView greetingLabel;
    @BindView(R.id.group)
    Group group;
    @BindView(R.id.container)
    NestedScrollView container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ButterKnife.bind(this);
        loadImages();
        hideDetails();
        getStudentDetails();
        loadNewsIntoWidget();
    }

    private void hideDetails() {
        group.setVisibility(View.GONE);
    }

    private void showDetails() {
        group.setVisibility(View.VISIBLE);
    }

    private void loadNewsIntoWidget() {
        NewsViewModel model = ViewModelProviders.of(this).get(NewsViewModel.class);
        model.getNewsList().observe(this, this::loadNews);
    }

    private void loadNews(List<News> news) {
        for (News n :
                news) {
            hiccsNewsWidget.append(" -- " + n.getTitle());
        }
        hiccsNewsWidget.setSelected(true);
        showDetails();
        TransitionManager.beginDelayedTransition(container);
    }

    private void getStudentDetails() {
        StudentViewModelFactory factory = new StudentViewModelFactory(
                Integer.valueOf(StudentSharedPreferenceHelper.getStudentIdFromSharedPreference(getSharedPreferences(Constants.STUDENT_SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE))));

        StudentProfileViewModel model = ViewModelProviders.of(this, factory).get(StudentProfileViewModel.class);
        model.getStudent().observe(this, this::setStudentDetails);
    }

    private void setStudentDetails(StudentAccountModel studentAccountModel) {
        Glide.with(this)
                .load(studentAccountModel.getImgUrl())
                .into(studentImageView);
        greetingLabel.setText("مرحباً، " + studentAccountModel.getFullName());

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
        Intent intent = new Intent(this, ExamsActivity.class);
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
