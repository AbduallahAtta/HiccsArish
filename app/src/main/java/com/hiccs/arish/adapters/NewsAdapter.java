package com.hiccs.arish.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.activities.NewsDetailsActivity;
import com.hiccs.arish.models.news.News;
import com.hiccs.arish.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AbdullahAtta on 2/26/2019.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context mContext;
    private List<News> mNews;

    public NewsAdapter(Context mContext, List<News> mNews) {
        this.mContext = mContext;
        this.mNews = mNews;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View newsView = LayoutInflater.from(mContext).inflate(R.layout.list_item_news, viewGroup, false);
        return new NewsViewHolder(newsView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        newsViewHolder.mTitle.setText(mNews.get(i).getTitle());
        Glide.with(mContext)
                .load(mNews.get(i).getImgUrl())
                .into(newsViewHolder.mImage);
    }

    @Override
    public int getItemCount() {
        return mNews == null ? 0 : mNews.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.listItemNewsImage)
        ImageView mImage;
        @BindView(R.id.listItemNewsTitle)
        TextView mTitle;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cardView)
        public void onNewsClick() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startNewsDetailsWithTransition();
            } else {
                startNewsDetailsActivity();
            }
        }

        /**
         * Won't be visible anyway until the imgUrl attribute
         * of the WebService returns real value
         */
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void startNewsDetailsWithTransition() {
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext,
                    mImage, mImage.getTransitionName()).toBundle();
            Intent intent = new Intent(mContext, NewsDetailsActivity.class);
            intent.putExtra(Constants.NEWS_SELECTED_INTENT_KEY, mNews.get(getAdapterPosition()));
            mContext.startActivity(intent, bundle);
        }

        private void startNewsDetailsActivity() {
            Intent intent = new Intent(mContext, NewsDetailsActivity.class);
            intent.putExtra(Constants.NEWS_SELECTED_INTENT_KEY, mNews.get(getAdapterPosition()));
            mContext.startActivity(intent);
        }
    }


}
