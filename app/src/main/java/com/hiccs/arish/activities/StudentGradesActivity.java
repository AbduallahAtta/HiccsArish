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
import com.hiccs.arish.adapters.StudentGradesAdapter;
import com.hiccs.arish.models.StudentGrades;
import com.hiccs.arish.viewmodel.StudentGradesViewModel;
import com.hiccs.arish.viewmodel.StudentViewModelFactory;
import com.victor.loading.rotate.RotateLoading;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentGradesActivity extends AppCompatActivity {

    @BindView(R.id.loadingIndicator)
    RotateLoading loadingIndicator;
    @BindView(R.id.StudentGradesRecyclerView)
    RecyclerView StudentGradesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grades);
        ButterKnife.bind(this);
        setupToolbar();
        getStudentGradesOfViewModel();
    }

    private void setupToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.student_grades_toolbar_title);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    private void getStudentGradesOfViewModel() {

        showLoadingIndicator();
        StudentViewModelFactory factory = new StudentViewModelFactory(1);

        StudentGradesViewModel StudentGradesViewModel = ViewModelProviders.of(this).get(StudentGradesViewModel.class);
        StudentGradesViewModel.StudentGradesList().observe(this, StudentGrades -> {
            hideLoadingIndicator();
            setStudentGradesAdapter(StudentGrades);
        });

    }

    private void hideLoadingIndicator() {
        loadingIndicator.stop();
        StudentGradesRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showLoadingIndicator() {
        StudentGradesRecyclerView.setVisibility(View.GONE);
        loadingIndicator.start();
    }

    private void setStudentGradesAdapter(List<StudentGrades> StudentGrades) {
        hideLoadingIndicator();
        StudentGradesAdapter adapter = new StudentGradesAdapter(this, StudentGrades);
        StudentGradesRecyclerView.setAdapter(adapter);
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

    private void getgrade(List<StudentGrades> StudentGrades) {

    }
}
