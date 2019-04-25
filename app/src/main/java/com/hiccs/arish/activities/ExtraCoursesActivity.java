package com.hiccs.arish.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.ExtraCoursesAdapter;
import com.hiccs.arish.models.ExtraCoursesModel;
import com.hiccs.arish.viewmodel.ExtraCoursesViewModel;
import com.victor.loading.rotate.RotateLoading;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExtraCoursesActivity extends AppCompatActivity {

    @BindView(R.id.loadingIndicator)
    RotateLoading loadingIndicator;
    @BindView(R.id.ExtraCoursesRecyclerView)
    RecyclerView ExtraCoursesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_courses);
        ButterKnife.bind(this);
        setupToolbar();
        getCoursesOfViewModel();
    }

    private void setupToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.extra_courses_toolbar_title);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    private void getCoursesOfViewModel() {

        showLoadingIndicator();
        ExtraCoursesViewModel coursesViewModel = ViewModelProviders.of(this).get(ExtraCoursesViewModel.class);
        coursesViewModel.Extra_Courses_List().observe(this, ExtraCoursesModel -> {
            hideLoadingIndicator();
            setCoursesToAdapter(ExtraCoursesModel);
        });

    }

    private void hideLoadingIndicator() {
        loadingIndicator.stop();
        ExtraCoursesRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showLoadingIndicator() {
        ExtraCoursesRecyclerView.setVisibility(View.GONE);
        loadingIndicator.start();
    }

    private void setCoursesToAdapter(List<ExtraCoursesModel> ExtraCoursesModel) {
        hideLoadingIndicator();
        ExtraCoursesAdapter adapter = new ExtraCoursesAdapter(this, ExtraCoursesModel);
        ExtraCoursesRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
