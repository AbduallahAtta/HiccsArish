package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StaffDetailsActivity extends AppCompatActivity {
    @BindView(R.id.DescribtionTextView)
    TextView DescribtionTextView;

    @BindView(R.id.ImageView)
    ImageView ImageView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;

    private StaffModel staffModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_details);
        ButterKnife.bind(this);
        if (getIntent() != null && getIntent().hasExtra(Constants.Staff_SELECTED_INTENT_KEY)) {
            staffModel = getIntent().getParcelableExtra(Constants.Staff_SELECTED_INTENT_KEY);
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
        collapsingToolbar.setTitle(staffModel.getDrName());
        Glide.with(this)
                .load(staffModel.getImgUrl())
                .into(ImageView);
        DescribtionTextView.setText(String.valueOf(staffModel.getDescription()));
    }

    @OnClick(R.id.shareNewsFab)
    public void onShareFABClick() {
        ShareCompat.IntentBuilder.from(this)
                .setChooserTitle(getString(R.string.share_article_text) + " " + staffModel.getDrName())
                .setType("text/plain")
                .setText("Check what's written by " +
                        "\n" + getString(R.string.app_name) +
                        "\n\n" + staffModel.getDescription())
                .startChooser();
    }
}

