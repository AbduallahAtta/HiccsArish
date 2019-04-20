package com.hiccs.arish.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.hiccs.arish.models.ExtraCoursesModel;
import com.hiccs.arish.rest.APIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtraCoursesViewModel extends ViewModel {
    private static final String TAG = ExtraCoursesViewModel.class.getSimpleName();
    private MutableLiveData<List<ExtraCoursesModel>> Extra_Courses_List;

    public MutableLiveData<List<ExtraCoursesModel>> Extra_Courses_List() {
        if (Extra_Courses_List == null) {
            Extra_Courses_List = new MutableLiveData<>();
            loadCourses();
        }
        return Extra_Courses_List;
    }

    private void loadCourses() {
        APIUtils.getHiccsAPI().getExtraCourses()
                .enqueue(new Callback<List<ExtraCoursesModel>>() {
                    @Override
                    public void onResponse(Call<List<ExtraCoursesModel>> call,
                                           Response<List<ExtraCoursesModel>> response) {
                        if (response.isSuccessful()) {
                            Extra_Courses_List.setValue(response.body());
                        } else {
                            logger(String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ExtraCoursesModel>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String message) {
        Log.d(TAG, message);
    }
}
