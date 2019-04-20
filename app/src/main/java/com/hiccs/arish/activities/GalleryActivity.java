package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.GalleryAdapter;
import com.hiccs.arish.models.GalleryImages;
import com.hiccs.arish.rest.APIUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        APIUtils.getHiccsAPI().getGalleryImages()
                .enqueue(new Callback<ArrayList<GalleryImages>>() {
                    @Override
                    public void onResponse(Call<ArrayList<GalleryImages>> call, Response<ArrayList<GalleryImages>> response) {
                        if (response.isSuccessful()) {
                            setupGalleryRecyclerView(response.body());
                        } else {
                            logger(String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<GalleryImages>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String message) {
        Log.d(TAG, message);
    }

    private void setupGalleryRecyclerView(ArrayList<GalleryImages> images) {
        GalleryAdapter adapter = new GalleryAdapter(this, images);
        galleryRecyclerView.setAdapter(adapter);
    }


}
