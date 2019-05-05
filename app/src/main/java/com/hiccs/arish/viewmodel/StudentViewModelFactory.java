package com.hiccs.arish.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * Created by AbdullahAtta on 5/5/2019.
 */
public class StudentViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private int mStudentId;

    public StudentViewModelFactory(int mStudentId) {
        this.mStudentId = mStudentId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StudentProfileViewModel.class)) {
            return (T) new StudentProfileViewModel(mStudentId);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class!! :/");
        }
    }
}
