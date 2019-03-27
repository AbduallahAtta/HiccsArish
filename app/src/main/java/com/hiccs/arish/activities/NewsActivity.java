package com.hiccs.arish.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.NewsAdapter;
import com.hiccs.arish.models.news.News;
import com.hiccs.arish.viewmodel.NewsViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity {
    @BindView(R.id.newsRecyclerView)
    RecyclerView mNewsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        getNewsOfViewModel();
    }

    private void getNewsOfViewModel() {
        NewsViewModel newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.getNewsList().observe(this, this::setNewsToAdapter);
    }

    private void setNewsToAdapter(List<News> news) {
        NewsAdapter adapter = new NewsAdapter(this, news);
        mNewsRecyclerView.setAdapter(adapter);
    }
}
