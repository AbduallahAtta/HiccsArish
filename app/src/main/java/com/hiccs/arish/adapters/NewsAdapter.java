package com.hiccs.arish.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.models.news.News;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    }
}
