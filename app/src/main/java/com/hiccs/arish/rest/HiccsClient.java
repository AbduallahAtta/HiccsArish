package com.hiccs.arish.rest;

/**
 * Created by AbdullahAtta on 2/26/2019.
 */

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.hiccs.arish.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * by leveraging the singleton approach
 * this is the class that's responsible for creating
 * the HICCS retrofit client
 */
public class HiccsClient {

    private static Retrofit sRetrofit;

    public static Retrofit getsRetrofit(String baseURL) {
        if (sRetrofit == null) {
            Log.v("server_data", "Started to get Retrofit");
            Log.v("HiccsArish", "Started to get Retrofit");
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                    .build();

        }
        Log.v(Constants.NETWORK_TAG, "Done getting Retrofit");
        Log.v("HiccsArish", "Done getting Retrofit");
        return sRetrofit;
    }
}

