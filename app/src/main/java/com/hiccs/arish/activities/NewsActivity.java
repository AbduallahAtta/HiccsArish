package com.hiccs.arish.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.NewsAdapter;
import com.hiccs.arish.models.news.News;
import com.hiccs.arish.viewmodel.NewsViewModel;
import com.victor.loading.rotate.RotateLoading;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity {
    @BindView(R.id.newsRecyclerView)
    RecyclerView mNewsRecyclerView;

    @BindView(R.id.loadingIndicator)
    RotateLoading loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        setupToolbar();
        getNewsOfViewModel();
    }

    private void setupToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.news_toolbar_title);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    private void getNewsOfViewModel() {

        showLoadingIndicator();
        NewsViewModel newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.getNewsList().observe(this, news -> {
            hideLoadingIndicator();
            setNewsToAdapter(news);
        });

    }

    private void hideLoadingIndicator() {
        loadingIndicator.stop();
        mNewsRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showLoadingIndicator() {
        mNewsRecyclerView.setVisibility(View.GONE);
        loadingIndicator.start();
    }

    private void setNewsToAdapter(List<News> news) {
        hideLoadingIndicator();
        NewsAdapter adapter = new NewsAdapter(this, news);
        mNewsRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
