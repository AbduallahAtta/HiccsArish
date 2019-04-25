package com.hiccs.arish.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.GalleryAdapter;
import com.hiccs.arish.models.GalleryImages;
import com.hiccs.arish.viewmodel.GalleryImagesViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = GalleryActivity.class.getSimpleName();
    @BindView(R.id.galleryRecyclerView)
    RecyclerView galleryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);
        loadGalleryImages();

    }

    private void loadGalleryImages() {
        GalleryImagesViewModel galleryViewModel = ViewModelProviders.of(this).get(GalleryImagesViewModel.class);
        galleryViewModel.getmImages().observe(this, this::setupGalleryRecyclerView);
    }

    private void logger(String message) {
        Log.d(TAG, message);
    }

    private void setupGalleryRecyclerView(ArrayList<GalleryImages> images) {
        GalleryAdapter adapter = new GalleryAdapter(this, images);
        galleryRecyclerView.setAdapter(adapter);
    }


}
