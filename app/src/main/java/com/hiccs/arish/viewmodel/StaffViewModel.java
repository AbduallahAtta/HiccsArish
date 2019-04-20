package com.hiccs.arish.viewmodel;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.rest.APIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StaffViewModel extends ViewModel {
    private static final String TAG = ExtraCoursesViewModel.class.getSimpleName();
    private MutableLiveData<List<StaffModel>> staff_List;

    public MutableLiveData<List<StaffModel>> staff_List() {
        if (staff_List == null) {
            staff_List = new MutableLiveData<>();
            loadStaff();
        }
        return staff_List;
    }

    private void loadStaff() {
        APIUtils.getHiccsAPI().getStaffModel()
                .enqueue(new Callback<List<StaffModel>>() {
                    @Override
                    public void onResponse(Call<List<StaffModel>> call,
                                           Response<List<StaffModel>> response) {
                        if (response.isSuccessful()) {
                            staff_List.setValue(response.body());
                        } else {
                            logger(String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<StaffModel>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String message) {
        Log.d(TAG, message);
    }
}
