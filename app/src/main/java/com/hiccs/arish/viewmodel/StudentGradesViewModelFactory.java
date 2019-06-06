package com.hiccs.arish.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * Created by AbdullahAtta on 5/31/2019.
 */
public class StudentGradesViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private String mStudentId;

    public StudentGradesViewModelFactory(String mStudentId) {
        this.mStudentId = mStudentId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StudentGradesViewModel.class)) {
            return (T) new StudentGradesViewModel(mStudentId);
        } else {
            throw new IllegalArgumentException("Class unsupported!");
        }
    }
}
