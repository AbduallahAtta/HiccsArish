package com.hiccs.arish.activities;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.hiccs.arish.R;
import com.hiccs.arish.models.GalleryImages;
import com.hiccs.arish.viewmodel.GalleryImagesViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.loginUserNameEditText)
    EditText loginUserNameEditText;
    @BindView(R.id.loginPasswordEditText)
    EditText loginPasswordEditText;
    @BindView(R.id.loginImage)
    KenBurnsView loginImage;
    private Animation fadeOutAnim;
    private Animation zoomInAnim;

    public static boolean isValidContextForGlide(Context context) {
        if (context == null) {
            return false;
        }
        if (context instanceof Activity) {
            final Activity activity = (Activity) context;
            return !activity.isDestroyed() && !activity.isFinishing();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loadGalleryImages();
    }

    private void loadGalleryImages() {
        GalleryImagesViewModel galleryViewModel = ViewModelProviders.of(this).get(GalleryImagesViewModel.class);
        galleryViewModel.getmImages().observe(this, galleryImages -> runGalleryAnimation(galleryImages));
    }

    private void runGalleryAnimation(final ArrayList<GalleryImages> images) {
        if (images.size() <= 0) {
            return;
        }

        fadeOutAnim = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        zoomInAnim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int counter = 1;

            @Override
            public void run() {
                String imageUrl = images.get(counter).getImgUrl();

                if (isValidContextForGlide(LoginActivity.this)) {
                    Glide.with(LoginActivity.this)
                            .load(imageUrl)
                            .into(loginImage);
                    loginImage.startAnimation(zoomInAnim);
                }
                counter++;
                if (counter > images.size() - 1) {
                    counter = 0;
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loginImage.startAnimation(fadeOutAnim);
                    }
                }, 2500);
                handler.postDelayed(this, 3500);
            }
        };
        handler.postDelayed(runnable, 3500);
    }

    @OnClick(R.id.loginButton)
    public void onViewClicked() {
        loginStudent();
//        if (Validation.isTextNotEmpty(getUsername())) {
//            if (Validation.isPasswordLengthEligible(getPassword())) {
//                loginStudent();
//            } else {
//                loginPasswordEditText.setError("Make sure you typed the password correctly");
//            }
//        } else {
//            loginUserNameEditText.setError("Make sure you typed the password correctly");
//        }
    }

    private void loginStudent() {
        // TODO: 4/9/2019 login
        Intent intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
    }

    @NonNull
    private String getUsername() {
        return loginUserNameEditText.getText().toString();
    }

    @NonNull
    private String getPassword() {
        return loginPasswordEditText.getText().toString();
    }
}
