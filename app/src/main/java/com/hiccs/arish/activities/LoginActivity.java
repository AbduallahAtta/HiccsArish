package com.hiccs.arish.activities;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.hiccs.arish.R;
import com.hiccs.arish.custom.LoginTextInputLayout;
import com.hiccs.arish.models.GalleryImages;
import com.hiccs.arish.models.Student;
import com.hiccs.arish.rest.APIUtils;
import com.hiccs.arish.utils.Constants;
import com.hiccs.arish.utils.Validation;
import com.hiccs.arish.viewmodel.GalleryImagesViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.loginUserNameEditText)
    EditText loginUserNameEditText;
    @BindView(R.id.loginPasswordEditText)
    EditText loginPasswordEditText;
    @BindView(R.id.loginImage)
    KenBurnsView loginImage;
    @BindView(R.id.loginButton)
    Button loginButton;
    @BindView(R.id.usernameTextLayout)
    LoginTextInputLayout usernameTextLayout;
    @BindView(R.id.loginPasswordTextLayout)
    LoginTextInputLayout loginPasswordTextLayout;

    private Animation fadeOutAnim;
    private Animation zoomInAnim;

    private static boolean isValidContextForGlide(Context context) {
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
        setupFullScreen();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loadGalleryImages();
        setupEditTextTextWatcher();
    }

    private void setupEditTextTextWatcher() {
        if (getPassword().trim().length() == 0) loginButton.setEnabled(false);
        loginPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    loginButton.setEnabled(false);
                } else {
                    loginButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setupFullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void loadGalleryImages() {
        GalleryImagesViewModel galleryViewModel = ViewModelProviders.of(this).get(GalleryImagesViewModel.class);
        galleryViewModel.getmImages().observe(this, this::runGalleryAnimation);
    }

    private void runGalleryAnimation(final ArrayList<GalleryImages> images) {
        if (images.size() <= 0) {
            return;
        }

        initAnimation();
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int counter = 1;

            @Override
            public void run() {
                String imageUrl = images.get(counter).getImgUrl();

                loadImage(imageUrl);
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

    private void loadImage(String imageUrl) {
        if (isValidContextForGlide(LoginActivity.this)) {
            Glide.with(LoginActivity.this)
                    .load(imageUrl)
                    .into(loginImage);
            loginImage.startAnimation(zoomInAnim);
        }
    }

    private void initAnimation() {
        fadeOutAnim = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        zoomInAnim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
    }

    @OnClick(R.id.loginButton)
    public void onLoginButtonClick() {
        if (Validation.isTextNotEmpty(getUsername())) {
            loginStudent();
        }
    }

    private void loginStudent() {
        APIUtils.getHiccsAPI()
                .loginStudent(getUsername(), getPassword())
                .enqueue(new Callback<List<Student>>() {
                    @Override
                    public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                        if (response.isSuccessful()) {
                            saveUserDetails(response.body().get(0));
                        } else {
                            logger(String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Student>> call, Throwable t) {
                        logger(t.getMessage());
                        showCredentialErrorMsg();
                    }
                });
    }

    private void showCredentialErrorMsg() {
        loginUserNameEditText.setText("");
        loginPasswordEditText.setText("");
        usernameTextLayout.setError("Auth Error, please check your credentials");
        loginPasswordTextLayout.setError("Auth Error, please check your credentials");
    }

    @NonNull
    private String getUsername() {
        return loginUserNameEditText.getText().toString();
    }

    @NonNull
    private String getPassword() {
        return loginPasswordEditText.getText().toString();
    }

    private void saveUserDetails(Student student) {
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.STUDENT_SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.STUDENT_DETAILS_SHARED_PREFERENCES_KEY, student.getStudentID());
        editor.commit();
        startStudentActivity();
    }

    private void startStudentActivity() {
        Intent intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
        finish();
    }

    private void logger(String message) {
        Log.v(TAG, message);
    }

}
