package com.hiccs.arish.custom;

import android.content.Context;
import android.graphics.ColorFilter;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;

/**
 * Created by AbdullahAtta on 5/9/2019.
 */

/**
 * The default colorFilter for setError method
 * is really ugly!
 * this class {@link LoginTextInputLayout} and {@link #updateBackgroundColorFilter(ColorFilter)}
 * is just a work around to solve this issue
 */
public class LoginTextInputLayout extends TextInputLayout {
    public LoginTextInputLayout(Context context) {
        super(context);
    }

    public LoginTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setError(@Nullable CharSequence error) {
        ColorFilter defaultColorFilter = getBackgroundDefaultColorFilter();
        super.setError(error);
        updateBackgroundColorFilter(defaultColorFilter);
    }

    @Override
    protected void drawableStateChanged() {
        ColorFilter defaultColorFilter = getBackgroundDefaultColorFilter();
        super.drawableStateChanged();
        updateBackgroundColorFilter(defaultColorFilter);
    }

    private void updateBackgroundColorFilter(ColorFilter colorFilter) {
        if (getEditText() != null && getEditText().getBackground() != null)
            getEditText().getBackground().setColorFilter(colorFilter);
    }

    @Nullable
    private ColorFilter getBackgroundDefaultColorFilter() {
        ColorFilter defaultColorFilter = null;
        if (getEditText() != null && getEditText().getBackground() != null)
            defaultColorFilter = DrawableCompat.getColorFilter(getEditText().getBackground());
        return defaultColorFilter;
    }
}
