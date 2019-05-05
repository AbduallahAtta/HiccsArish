package com.hiccs.arish.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.hiccs.arish.models.StudentAccountModel;
import com.hiccs.arish.rest.APIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AbdullahAtta on 5/5/2019.
 */
public class StudentProfileViewModel extends ViewModel {
    private static final String TAG = StudentProfileViewModel.class.getSimpleName();
    private int mStudentId;
    private MutableLiveData<StudentAccountModel> mStudent;

    public StudentProfileViewModel(int mStudentId) {
        this.mStudentId = mStudentId;
    }

    public MutableLiveData<StudentAccountModel> getStudent() {
        if (mStudent == null) {
            mStudent = new MutableLiveData<>();
            loadStudentProfile();
        }
        return mStudent;
    }

    private void loadStudentProfile() {
        APIUtils.getHiccsAPI().StudentInformation(mStudentId)
                .enqueue(new Callback<List<StudentAccountModel>>() {
                    @Override
                    public void onResponse(Call<List<StudentAccountModel>> call, Response<List<StudentAccountModel>> response) {
                        if (response.isSuccessful()) {
                            mStudent.setValue(response.body().get(0));
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

    private void logger(String message) {
        Log.v(TAG, message);
    }
}
