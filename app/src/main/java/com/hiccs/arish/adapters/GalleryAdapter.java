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
import com.hiccs.arish.activities.GalleryDetailsActivity;
import com.hiccs.arish.models.GalleryImages;
import com.hiccs.arish.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AbdullahAtta on 2/19/2019.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private Context mContext;
    private ArrayList<GalleryImages> mGallery;

    public GalleryAdapter(Context mContext, ArrayList<GalleryImages> mGallery) {
        this.mContext = mContext;
        this.mGallery = mGallery;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View galleryView = LayoutInflater.from(mContext).inflate(R.layout.list_item_gallery, viewGroup, false);
        return new GalleryViewHolder(galleryView);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder galleryViewHolder, int i) {
        Glide.with(mContext)
                .load(mGallery.get(i).getImgUrl())
                .thumbnail(0.25f)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(galleryViewHolder.galleryImage);
    }

    @Override
    public int getItemCount() {
        return mGallery == null ? 0 : mGallery.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.listItemGalleryImage)
        ImageView galleryImage;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.listItemGalleryImage)
        public void onImageClick() {
            Intent intent = new Intent(mContext, GalleryDetailsActivity.class);
            intent.putParcelableArrayListExtra(Constants.GALLERY_LIST_INTENT_KEY, mGallery);
            intent.putExtra(Constants.GALLERY_POSITION_INTENT_KEY, getAdapterPosition());
            mContext.startActivity(intent);
        }
    }
}

