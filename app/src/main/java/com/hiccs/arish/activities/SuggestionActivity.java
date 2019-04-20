package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.hiccs.arish.R;
import com.hiccs.arish.models.Suggestion;
import com.hiccs.arish.rest.APIUtils;
import com.hiccs.arish.utils.Validation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuggestionActivity extends AppCompatActivity {
    private static final String TAG = SuggestionActivity.class.getSimpleName();
    @BindView(R.id.suggestBodyEditText)
    EditText suggestBodyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        ButterKnife.bind(this);
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
        APIUtils.getHiccsAPI().postSuggestion(new Suggestion(suggestBodyEditText.getText().toString(), "", ""))
                .enqueue(new Callback<Suggestion>() {
                    @Override
                    public void onResponse(Call<Suggestion> call, Response<Suggestion> response) {
                        if (response.isSuccessful()) {

                        } else {
                            logger(String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Suggestion> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String s) {
        Log.v(TAG, s);
    }
}
