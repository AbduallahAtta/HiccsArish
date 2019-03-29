package com.hiccs.arish.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.hiccs.arish.R;
import com.hiccs.arish.utils.Constants;
import com.michaldrabik.tapbarmenulib.TapBarMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    @BindView(R.id.tapBarMenu)
    TapBarMenu tapBarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setupSocialNetworksMenuClick();
    }

    private void setupSocialNetworksMenuClick() {
        tapBarMenu.setOnClickListener(v -> tapBarMenu.toggle());
    }

    @OnClick({R.id.staffParent, R.id.galleryParent, R.id.extraCoursesParent, R.id.newsParent, R.id.aboutParent, R.id.hiccsWebSiteImage, R.id.hiccsFacebookImage, R.id.hiccsYoutubeImage, R.id.hiccsLinkedInImage, R.id.hiccsLocationImage, R.id.hiccsLandLineNumberImage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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

    private void startStaffActivity() {
        Intent intent = new Intent(this, StaffActivity.class);
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

    private void startAboutActivity() {
        // TODO: 3/26/2019 throws RuntimeException, needs to be fixed
        Intent intent = new Intent(this, AboutActivity.class);
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
