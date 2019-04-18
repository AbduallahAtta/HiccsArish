package com.hiccs.arish.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.hiccs.arish.R;
import com.hiccs.arish.utils.Validation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.loginUserNameEditText)
    EditText loginUserNameEditText;
    @BindView(R.id.loginPasswordEditText)
    EditText loginPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginButton)
    public void onViewClicked() {
        if (Validation.isTextNotEmpty(getUsername())) {
            if (Validation.isPasswordLengthEligible(getPassword())) {
                loginStudent();
            } else {
                loginPasswordEditText.setError("Make sure you typed the password correctly");
            }
        } else {
            loginUserNameEditText.setError("Make sure you typed the password correctly");
        }
    }

    private void loginStudent() {
        // TODO: 4/9/2019 login
    }

    @NonNull
    private String getUsername() {
        return loginUserNameEditText.getText().toString();
    }

    @NonNull
    private String getPassword() {
        return loginPasswordEditText.getText().toString();
    }
}
