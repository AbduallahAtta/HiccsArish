package com.hiccs.arish.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.models.ExtraCoursesModel;
import com.hiccs.arish.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExtraCoursesDetailsActivity extends AppCompatActivity {


    @BindView(R.id.extra_course_des)
    TextView extra_course_des;

    @BindView(R.id.extra_course_img)
    ImageView extra_course_img;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;

    private ExtraCoursesModel extraCoursesModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_courses_details);
        ButterKnife.bind(this);
        if (getIntent() != null && getIntent().hasExtra(Constants.EXTRA_COURSES_SELECTED_INTENT_KEY)) {
            extraCoursesModel = getIntent().getParcelableExtra(Constants.EXTRA_COURSES_SELECTED_INTENT_KEY);
            setupViews();
        } else {
            errorUponLaunch();
        }
    }

    private void errorUponLaunch() {
        Toast.makeText(this, R.string.activity_launch_error_msg, Toast.LENGTH_SHORT).show();
        finish();
    }

    private void setupViews() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        collapsingToolbar.setTitle(extraCoursesModel.getCourseName());
        Glide.with(this)
                .load(extraCoursesModel.getImgUrl())
                .into(extra_course_img);
        extra_course_des.setText(String.valueOf(extraCoursesModel.getDescription()));
    }

    @OnClick(R.id.shareNewsFab)
    public void onShareFABClick() {
        ShareCompat.IntentBuilder.from(this)
                .setChooserTitle(getString(R.string.share_article_text) + " " + extraCoursesModel.getCourseName())
                .setType("text/plain")
                .setText("Check what's written by " +
                        "\n" + getString(R.string.app_name) +
                        "\n\n" + extraCoursesModel.getDescription())
                .startChooser();
    }
}
