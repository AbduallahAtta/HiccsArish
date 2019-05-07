package com.hiccs.arish.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.hiccs.arish.R;
import com.hiccs.arish.activities.ExamImageDetailsActivity;
import com.hiccs.arish.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AbdullahAtta on 5/7/2019.
 */
public class ExamsImagesAdapter extends RecyclerView.Adapter<ExamsImagesAdapter.ExamsImagesViewHolder> {
    private Context mContext;
    private ArrayList<String> mExamImages;

    public ExamsImagesAdapter(Context mContext, ArrayList<String> exams) {
        this.mContext = mContext;
        this.mExamImages = exams;
    }

    @NonNull
    @Override
    public ExamsImagesAdapter.ExamsImagesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View examsView = LayoutInflater.from(mContext).inflate(R.layout.list_item_gallery, viewGroup, false);
        return new ExamsImagesAdapter.ExamsImagesViewHolder(examsView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamsImagesAdapter.ExamsImagesViewHolder examsImagesViewHolder, int i) {
        Glide.with(mContext)
                .load(mExamImages.get(i))
                .thumbnail(0.25f)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(examsImagesViewHolder.galleryImage);
    }

    @Override
    public int getItemCount() {
        return mExamImages == null ? 0 : mExamImages.size();
    }

    public class ExamsImagesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.listItemGalleryImage)
        ImageView galleryImage;

        public ExamsImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.listItemGalleryImage)
        public void onImageClick() {
            Intent intent = new Intent(mContext, ExamImageDetailsActivity.class);
            intent.putStringArrayListExtra(Constants.EXAMS_IMAGES_LIST_INTENT_KEY, mExamImages);
            intent.putExtra(Constants.EXAMS_IMAGES_POSITION_INTENT_KEY, getAdapterPosition());
            mContext.startActivity(intent);
        }
    }
}