package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.ExtraCoursesAdapter;
import com.hiccs.arish.adapters.StaffAdapter;
import com.hiccs.arish.models.ExtraCoursesModel;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.rest.APIUtils;
import com.hiccs.arish.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtraCoursesActivity extends AppCompatActivity {

    private static final String TAG = ExtraCoursesActivity.class.getSimpleName();
    @BindView(R.id.ExtraCoursesRecyclerView)
    RecyclerView ExtraCoursesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_courses);
        ButterKnife.bind(this);
        ExtraCourses();
    }


    private void ExtraCourses() {
        logger("Started to fetch data");
        APIUtils.getHiccsAPI().getExtraCourses()
                .enqueue(new Callback<List<ExtraCoursesModel>>() {
                    @Override
                    public void onResponse(Call<List<ExtraCoursesModel>> call, Response<List<ExtraCoursesModel>> response) {
                        logger("Started to get response");


                        if (response.isSuccessful()) {
                            linkExtraCoursesAdapter(response.body());

                            logger(response.body().get(0).toString());
                            logger(response.body().get(0).getCourseName());
                        } else {
                            logger("response code = " + response.code());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<ExtraCoursesModel>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String s) {
        Log.v(Constants.NETWORK_TAG,s);
        Log.v("HiccsArish",s);
    }

    private void linkExtraCoursesAdapter(List<ExtraCoursesModel> body) {
        ExtraCoursesAdapter adapter = new ExtraCoursesAdapter(this, body);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ExtraCoursesRecyclerView.setLayoutManager(linearLayoutManager);
        ExtraCoursesRecyclerView.setAdapter(adapter);
    }

}
