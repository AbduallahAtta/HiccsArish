package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;
import com.hiccs.arish.R;
import com.hiccs.arish.custom.SuggestSuccessDialog;
import com.hiccs.arish.utils.Constants;
import com.hiccs.arish.utils.Validation;
import com.victor.loading.rotate.RotateLoading;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuggestionActivity extends AppCompatActivity {
    private static final String TAG = SuggestionActivity.class.getSimpleName();
    @BindView(R.id.suggestBodyEditText)
    EditText suggestBodyEditText;
    @BindView(R.id.loadingIndicator)
    RotateLoading loadingIndicator;
    @BindView(R.id.suggestionGroup)
    Group suggestionGroup;
    private FirebaseFirestore mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        ButterKnife.bind(this);
        initFirestore();
    }

    private void initFirestore() {
        mDatabase = FirebaseFirestore.getInstance();
    }

    @OnClick(R.id.submitSuggestButton)
    public void onSubmitButtonClicked() {
        String suggestBody = suggestBodyEditText.getText().toString();
        if (Validation.isTextNotEmpty(suggestBody)) {
            submitSuggestion();
        } else {
            suggestBodyEditText.setError("Please type in your suggestion");
        }
    }

    private void submitSuggestion() {
        showLoadingIndicator();
        mDatabase.collection(Constants.SUGGESTIONS_COLLECTION_NAME)
                .add(getSuggestionsMap())
                .addOnSuccessListener(documentReference -> {
                    showSuccessDialog();
                    hideLoadingIndicator();
                })
                .addOnFailureListener(e -> {
                    hideLoadingIndicator();
                    logger(e.getMessage());
                });
    }

    private void showSuccessDialog() {
        SuggestSuccessDialog ssd = new SuggestSuccessDialog();
        ssd.showSuggestSuccessDialog(this);
    }

    private Map<String, Object> getSuggestionsMap() {
        Map<String, Object> suggestion = new HashMap<>();
        suggestion.put("content", getSuggestionBody());
        suggestion.put("studentId", 1);
        return suggestion;
    }

    private String getSuggestionBody() {
        return suggestBodyEditText.getText().toString();
    }

    private void logger(String s) {
        Log.v(TAG, s);
    }

    private void showLoadingIndicator() {
        suggestionGroup.setVisibility(View.GONE);
        loadingIndicator.start();
    }

    private void hideLoadingIndicator() {
        loadingIndicator.stop();
        suggestionGroup.setVisibility(View.VISIBLE);
    }
}
