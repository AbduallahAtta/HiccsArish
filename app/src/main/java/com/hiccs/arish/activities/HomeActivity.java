package com.hiccs.arish.activities;

import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hiccs.arish.R;
import com.hiccs.arish.utils.Constants;
import com.hiccs.arish.utils.StudentSharedPreferenceHelper;
import com.michaldrabik.tapbarmenulib.TapBarMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    @BindView(R.id.tapBarMenu)
    TapBarMenu tapBarMenu;
    @BindView(R.id.studentLoginKBV)
    KenBurnsView studentLoginKBV;
    @BindView(R.id.staffImage)
    ImageView staffImage;
    @BindView(R.id.galleryImageView)
    ImageView galleryImageView;
    @BindView(R.id.extraCoursesImageView)
    ImageView extraCoursesImageView;
    @BindView(R.id.newsImageView)
    ImageView newsImageView;
    @BindView(R.id.aboutImageView)
    ImageView aboutImageView;

    private FirebaseFirestore mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        loadImages();
        loadDatabase();
        setupSocialNetworksMenuClick();
    }

    private void loadDatabase() {

    }

    private void loadImages() {
        Glide.with(this).load(Constants.EXTRA_COURSES_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(extraCoursesImageView);

        Glide.with(this).load(R.drawable.hiccs_building_image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(studentLoginKBV);

        Glide.with(this).load(Constants.NEWS_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(newsImageView);

        Glide.with(this).load(Constants.GALLERY_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(galleryImageView);

        Glide.with(this).load(Constants.ABOUT_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(aboutImageView);

        Glide.with(this).load(Constants.STAFF_IMAGE_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(staffImage);
    }

    private void setupSocialNetworksMenuClick() {
        tapBarMenu.setOnClickListener(v -> tapBarMenu.toggle());
    }

    @OnClick({R.id.studentImageProfile, R.id.staffParent, R.id.galleryParent, R.id.extraCoursesParent,
            R.id.newsParent, R.id.aboutParent, R.id.hiccsWebSiteImage, R.id.hiccsFacebookImage, R.id.hiccsYoutubeImage,
            R.id.hiccsLinkedInImage, R.id.hiccsLocationImage, R.id.hiccsLandLineNumberImage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.studentImageProfile:
                startStudentLoginActivity();
                break;
            case R.id.staffParent:
                startStaffActivity();
                break;
            case R.id.galleryParent:
                startGalleryActivity();
                break;
            case R.id.extraCoursesParent:
                startCoursesActivity();
                break;
            case R.id.newsParent:
                startNewsActivity();
                break;
            case R.id.aboutParent:
                startAboutActivity();
                break;
            case R.id.hiccsFacebookImage:
                openHiccsFacebookPage();
                break;
            case R.id.hiccsWebSiteImage:
                openHiccsWebsite();
                break;
            case R.id.hiccsYoutubeImage:
                openHiccsYouTubeChannel();
                break;
            case R.id.hiccsLinkedInImage:
                openHiccsLinkedInPage();
                break;
            case R.id.hiccsLandLineNumberImage:
                dialHiccsLandLineNumber();
                break;
            case R.id.hiccsLocationImage:
                openHiccsLocation();
                break;
        }
    }

    private void startStudentLoginActivity() {
        if (StudentSharedPreferenceHelper.isStudentDetailsExists(getSharedPreferences(Constants.STUDENT_SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE))) {
            startStudentAccountActivity();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startLoginActivityWithTransition();
            } else {
                startLoginActivity();
            }
        }
    }

    private void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startLoginActivityWithTransition() {
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent, bundle);
    }

    private void startStudentAccountActivity() {
        Intent intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
    }

    private void startStaffActivity() {
        Intent intent = new Intent(this, StafffActivity.class);
        startActivity(intent);
    }

    private void startAboutActivity() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void startGalleryActivity() {
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    private void startCoursesActivity() {
        Intent intent = new Intent(this, ExtraCoursesActivity.class);
        startActivity(intent);
    }

    private void startNewsActivity() {
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }


    private void openHiccsYouTubeChannel() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.HICCS_YOUTUBE_CHANNEL));
            intent.setPackage("com.google.android.youtube");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.HICCS_YOUTUBE_CHANNEL));
            startActivity(intent);
        }
    }

    private void openHiccsLinkedInPage() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.HICCS_LINKED_IN_PAGE));
            intent.setPackage("com.linkedin.android");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            logger(e.getMessage());
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.HICCS_LINKED_IN_PAGE));
            startActivity(intent);
        }
    }

    private void openHiccsWebsite() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.HICCS_WEBSITE));
        startActivity(intent);
    }

    private void openHiccsLocation() {
        Intent intent = new Intent(Intent.ACTION_VIEW, getLocationBuilder().build());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private Uri.Builder getLocationBuilder() {
        return new Uri.Builder()
                .scheme("geo")
                .path(Constants.HICCS_LONGITUDE + "," + Constants.HICCS_LATITUDE)
                .appendQueryParameter("q", Constants.HICCS_LOCATION_QUERY);
    }


    private void dialHiccsLandLineNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Constants.HICCS_LAND_LINE_NUMBER));
        startActivity(intent);
    }

    private void openHiccsFacebookPage() {
        Intent intent = getFacebookIntent();
        startActivity(intent);
    }

    private Intent getFacebookIntent() {
        try {
            if (getFacebookApplicationInfo().enabled) {
                Uri facebookUri = Uri.parse("fb://facewebmodal/f?href=" + Constants.HICCS_FACEBOOK_PAGE);
                return new Intent(Intent.ACTION_VIEW, facebookUri);
            }
        } catch (PackageManager.NameNotFoundException e) {
            logger(e.getMessage());
        }
        return new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.HICCS_FACEBOOK_PAGE));


    }

    private void logger(String message) {
        Log.d(TAG, message);
    }


    private ApplicationInfo getFacebookApplicationInfo() throws PackageManager.NameNotFoundException {
        return getPackageManager().getApplicationInfo("com.facebook.katana", 0);
    }

}
