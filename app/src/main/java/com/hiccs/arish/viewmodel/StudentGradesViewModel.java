package com.hiccs.arish.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.hiccs.arish.models.StudentGrades;
import com.hiccs.arish.rest.APIUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentGradesViewModel extends ViewModel {
    private static final String TAG = StudentGradesViewModel.class.getSimpleName();
    private int StudentID;

    private MutableLiveData<List<StudentGrades>> StudentGradesList;

    public StudentGradesViewModel(int StudentID) {
        this.StudentID = StudentID;
    }

    public MutableLiveData<List<StudentGrades>> StudentGradesList() {
        if (StudentGradesList == null) {
            StudentGradesList = new MutableLiveData<>();
            loadStudentGrades();
        }
        return StudentGradesList;
    }

    private void loadStudentGrades() {
        APIUtils.getHiccsAPI().StudentGrades(1)
                .enqueue(new Callback<List<StudentGrades>>() {
                    @Override
                    public void onResponse(Call<List<StudentGrades>> call,
                                           Response<List<StudentGrades>> response) {
                        if (response.isSuccessful()) {
                            StudentGradesList.setValue(response.body());

                        } else {
                            logger(String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<StudentGrades>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String message) {
        Log.d(TAG, message);
    }
}
