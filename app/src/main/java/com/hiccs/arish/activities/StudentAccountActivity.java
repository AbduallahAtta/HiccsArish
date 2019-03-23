package com.hiccs.arish.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.StaffAdapter;
import com.hiccs.arish.adapters.StudentInformationsAdapter;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.models.StudentAccountModel;
import com.hiccs.arish.rest.APIUtils;
import com.hiccs.arish.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentAccountActivity extends AppCompatActivity {
    private static final String TAG = StudentAccountActivity.class.getSimpleName();
    @BindView(R.id.StudentInformations)
    RecyclerView StudentInformations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_account);

     ButterKnife.bind(this);
    StudentInfoData();
}


    private void StudentInfoData() {
        logger("Started to fetch StudentInformation");
        APIUtils.getHiccsAPI().StudentInformation(1)
                .enqueue(new Callback<List<StudentAccountModel>>() {
                    @Override
                    public void onResponse(Call<List<StudentAccountModel>> call, Response<List<StudentAccountModel>> response) {
                        logger("Started to get response");

                        if (response.isSuccessful()) {
                            linkStudentInfoAdapter(response.body());

                            logger(response.body().get(0).toString());
                            logger(response.body().get(0).getFullName());
                        } else {
                            logger("response code = " + response.code());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<StudentAccountModel>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String s) {
        Log.v(Constants.NETWORK_TAG,s);
        Log.v("HiccsArish",s);
    }
    private void linkStudentInfoAdapter(List<StudentAccountModel> body) {
        StudentInformationsAdapter adapter = new StudentInformationsAdapter(this, body);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        StudentInformations.setLayoutManager(linearLayoutManager);
        StudentInformations.setAdapter(adapter);
    }

}
