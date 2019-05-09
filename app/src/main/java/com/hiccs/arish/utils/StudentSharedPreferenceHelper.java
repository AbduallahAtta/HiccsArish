package com.hiccs.arish.utils;

import android.content.SharedPreferences;

/**
 * Created by AbdullahAtta on 5/9/2019.
 */
public class StudentSharedPreferenceHelper {
    private static SharedPreferences mSharedPreference;

    public static boolean isStudentDetailsExists(SharedPreferences sharedPreferences) {
        String id = sharedPreferences.getString(Constants.STUDENT_DETAILS_SHARED_PREFERENCES_KEY, "");
        return sharedPreferences.contains(Constants.STUDENT_DETAILS_SHARED_PREFERENCES_KEY);
    }

    public static String getStudentIdFromSharedPreference(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(Constants.STUDENT_DETAILS_SHARED_PREFERENCES_KEY, "");
    }
}
