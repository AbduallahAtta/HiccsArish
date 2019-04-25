package com.hiccs.arish.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.hiccs.arish.models.GalleryImages;
import com.hiccs.arish.rest.APIUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AbdullahAtta on 4/20/2019.
 */
public class GalleryImagesViewModel extends ViewModel {
    private static final String TAG = GalleryImagesViewModel.class.getSimpleName();
    private MutableLiveData<ArrayList<GalleryImages>> mImages;

    public MutableLiveData<ArrayList<GalleryImages>> getmImages() {
        if (mImages == null) {
            mImages = new MutableLiveData<>();
            loadImages();
        }
        return mImages;
    }

    private void loadImages() {
        APIUtils.getHiccsAPI().getGalleryImages()
                .enqueue(new Callback<ArrayList<GalleryImages>>() {
                    @Override
                    public void onResponse(Call<ArrayList<GalleryImages>> call, Response<ArrayList<GalleryImages>> response) {
                        if (response.isSuccessful()) {
                            mImages.setValue(response.body());
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

}
