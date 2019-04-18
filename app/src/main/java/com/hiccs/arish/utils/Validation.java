package com.hiccs.arish.utils;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Created by AbdullahAtta on 4/9/2019.
 */
public class Validation {
    public static boolean isPasswordLengthEligible(String text) {
        return (isTextNotEmpty(text)) && (Pattern.compile(ValidationPatterns.PASSWORD_LENGTH_PATTERN)
                .matcher(text).matches());
    }

    public static boolean isTextNotEmpty(String text) {
        return !(TextUtils.isEmpty(text));
    }
}
