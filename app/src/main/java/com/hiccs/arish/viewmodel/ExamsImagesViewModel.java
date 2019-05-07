package com.hiccs.arish.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.google.firebase.firestore.FirebaseFirestore;
import com.hiccs.arish.models.Exams;
import com.hiccs.arish.utils.Constants;

/**
 * Created by AbdullahAtta on 5/7/2019.
 */
public class ExamsImagesViewModel extends ViewModel {
    private MutableLiveData<Exams> mExams;
    private FirebaseFirestore mDatabase;

    public MutableLiveData<Exams> getmExams() {
        if (mExams == null) {
            mDatabase = FirebaseFirestore.getInstance();
            mExams = new MutableLiveData<>();
            loadExams();
        }
        return mExams;
    }

    private void loadExams() {
        mDatabase = FirebaseFirestore.getInstance();
        mDatabase.collection(Constants.EXAMS_COLLECTION_NAME)
                .document("y4mis")
                .addSnapshotListener((documentSnapshot, e) -> {
                    Exams exams = documentSnapshot.toObject(Exams.class);
                    mExams.setValue(exams);
                });
    }
}
