package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.custom.DepthPageTransformer;
import com.hiccs.arish.models.GalleryImages;
import com.hiccs.arish.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryDetailsActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.container)
    ViewPager viewPager;

    private ArrayList<GalleryImages> mImages;
    private int mSelectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (getIntent() != null ||
                getIntent().hasExtra(Constants.GALLERY_POSITION_INTENT_KEY) ||
                getIntent().hasExtra(Constants.GALLERY_LIST_INTENT_KEY)) {
            getImagesFromIntent();
            setTitle(mImages.get(mSelectedPosition).getId());
            setupViewPager();
        } else {
            errorUponLaunch();
        }
    }


    private void getImagesFromIntent() {
        mImages = getIntent().getParcelableArrayListExtra(Constants.GALLERY_LIST_INTENT_KEY);
        mSelectedPosition = getIntent().getIntExtra(Constants.GALLERY_POSITION_INTENT_KEY, -1);
    }

    private void errorUponLaunch() {
        Toast.makeText(this, R.string.activity_launch_error_msg, Toast.LENGTH_SHORT).show();
        finish();
    }

    private void setupViewPager() {
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), mImages);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        viewPager.setAdapter(mSectionsPagerAdapter);
        viewPager.setCurrentItem(mSelectedPosition);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                setTitle(mImages.get(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_IMG_TITLE = "image_name";
        private static final String ARG_IMG_URL = "image_url";
        String imageName;
        String imageUrl;
        int position;

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber, String imageName, String imageUrl) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_IMG_TITLE, imageName);
            args.putString(ARG_IMG_URL, imageUrl);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void setArguments(Bundle args) {
            super.setArguments(args);
            this.position = args.getInt(ARG_SECTION_NUMBER);
            this.imageName = args.getString(ARG_IMG_TITLE);
            this.imageUrl = args.getString(ARG_IMG_URL);
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_image_details, container, false);
            ImageView image = rootView.findViewById(R.id.fragmentDetailsImage);
            Glide.with(this).load(imageUrl).into(image);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public List<GalleryImages> gallery;

        public SectionsPagerAdapter(FragmentManager fm, ArrayList<GalleryImages> mImages) {
            super(fm);
            this.gallery = mImages;
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position,
                    gallery.get(position).getId(),
                    gallery.get(position).getImgUrl());
        }

        @Override
        public int getCount() {
            return gallery.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return gallery.get(position).getId();
        }
    }


}

