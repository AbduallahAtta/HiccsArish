package com.hiccs.arish.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.ExamsImagesAdapter;
import com.hiccs.arish.viewmodel.ExamsImagesViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExamsActivity extends AppCompatActivity {

    @BindView(R.id.examsImagesRecyclerView)
    RecyclerView examsImagesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);
        ButterKnife.bind(this);
        loadExamsImages();
    }

    private void loadExamsImages() {
        ExamsImagesViewModel viewModel = ViewModelProviders.of(this).get(ExamsImagesViewModel.class);
        viewModel.getmExams().observe(this,
                exams -> setImages(exams.getExams()));
    }

    private void setImages(ArrayList<String> exams) {
        ExamsImagesAdapter adapter = new ExamsImagesAdapter(this, exams);
        examsImagesRecyclerView.setAdapter(adapter);
    }
}
