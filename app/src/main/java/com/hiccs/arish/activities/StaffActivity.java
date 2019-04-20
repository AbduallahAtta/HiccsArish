package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.StaffAdapter;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.rest.APIUtils;
import com.hiccs.arish.utils.Constants;
import com.victor.loading.rotate.RotateLoading;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StaffActivity extends AppCompatActivity {

    private static final String TAG = StaffActivity.class.getSimpleName();
    @BindView(R.id.staff_recycler)
    RecyclerView StaffRecyclerView;

    @BindView(R.id.loadingIndicator)
    RotateLoading loadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        ButterKnife.bind(this);
        StaffData();
    }


    private void StaffData() {
        logger("Started to fetch staff");
        APIUtils.getHiccsAPI().getStaffModel()
                .enqueue(new Callback<List<StaffModel>>() {
                    @Override
                    public void onResponse(Call<List<StaffModel>> call, Response<List<StaffModel>> response) {
                        logger("Started to get response");

                        if (response.isSuccessful()) {
                            linkstaffAdapter(response.body());

                            logger(response.body().get(0).toString());
                            logger(response.body().get(0).getDrName());
                        } else {
                            logger("response code = " + response.code());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<StaffModel>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String s) {
        Log.v(Constants.NETWORK_TAG, s);
        Log.v("HiccsArish", s);
    }

    private void hideLoadingIndicator() {
        loadingIndicator.stop();
        StaffRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showLoadingIndicator() {
        StaffRecyclerView.setVisibility(View.GONE);
        loadingIndicator.start();
    }

    private void linkstaffAdapter(List<StaffModel> body) {
        StaffAdapter adapter = new StaffAdapter(this, body);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        StaffRecyclerView.setLayoutManager(linearLayoutManager);
        StaffRecyclerView.setAdapter(adapter);
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
