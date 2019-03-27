package com.hiccs.arish.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.hiccs.arish.models.news.News;
import com.hiccs.arish.rest.APIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AbdullahAtta on 3/27/2019.
 */
public class NewsViewModel extends ViewModel {
    private static final String TAG = NewsViewModel.class.getSimpleName();
    private MutableLiveData<List<News>> mNewsList;

    public MutableLiveData<List<News>> getNewsList() {
        if (mNewsList == null) {
            mNewsList = new MutableLiveData<>();
            loadNews();
        }
        return mNewsList;
    }

    private void loadNews() {
        APIUtils.getHiccsAPI().getHICCSNews()
                .enqueue(new Callback<List<News>>() {
                    @Override
                    public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                        if (response.isSuccessful()) {
                            mNewsList.setValue(response.body());
                        } else {
                            logger(String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<News>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String message) {
        Log.d(TAG, message);
    }
}
