package com.hiccs.arish.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Group;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hiccs.arish.R;
import com.hiccs.arish.models.StudentAccountModel;
import com.hiccs.arish.viewmodel.StudentProfileViewModel;
import com.hiccs.arish.viewmodel.StudentViewModelFactory;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;
import com.transitionseverywhere.extra.Scale;
import com.victor.loading.rotate.RotateLoading;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class StudentAccountActivity extends AppCompatActivity {

    @BindView(R.id.studentAddressTextView)
    TextView studentAddressTextView;
    @BindView(R.id.blurredBackgroundImage)
    ImageView backgroundImage;
    @BindView(R.id.studentProfileImage)
    CircleImageView studentProfileImage;
    @BindView(R.id.studentNameTextView)
    TextView studentNameTextView;
    @BindView(R.id.studentPhoneTextView)
    TextView studentPhoneTextView;
    @BindView(R.id.studentDepartmentTextView)
    TextView studentDepartmentTextView;
    @BindView(R.id.studentAcademicYearTextView)
    TextView studentAcademicYearTextView;
    @BindView(R.id.loadingIndicator)
    RotateLoading loadingIndicator;
    @BindView(R.id.studentProfileGroupViews)
    Group studentProfileGroup;
    @BindView(R.id.container)
    ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_account);
        ButterKnife.bind(this);
        loadStudentProfile();
    }

    private void loadStudentProfile() {
        showLoadingIndicator();
        StudentViewModelFactory factory = new StudentViewModelFactory(2);
        StudentProfileViewModel viewModel = ViewModelProviders.of(this, factory).get(StudentProfileViewModel.class);
        viewModel.getStudent().observe(this, this::populateStudentDetails);
    }

    private void populateStudentDetails(StudentAccountModel studentAccountModel) {
        hideLoadingIndicator();
        Glide.with(this)
                .load(studentAccountModel.getImgUrl())
                .apply(new RequestOptions().transform(new BlurTransformation(20)))
                .into(backgroundImage);

        Glide.with(this)
                .load(studentAccountModel.getImgUrl())
                .into(studentProfileImage);

        studentNameTextView.setText(studentAccountModel.getFullName());
        studentAddressTextView.setText(studentAccountModel.getAddress());
        studentAcademicYearTextView.setText(String.valueOf(studentAccountModel.getAcademicYearNum()));
        studentPhoneTextView.setText(String.valueOf(studentAccountModel.getPhone()));
        studentDepartmentTextView.setText(studentAccountModel.getDepartmentName());
    }

    private void showLoadingIndicator() {
        studentProfileGroup.setVisibility(View.INVISIBLE);
        loadingIndicator.start();
    }

    private void hideLoadingIndicator() {
        loadingIndicator.stop();
        studentProfileGroup.setVisibility(View.VISIBLE);
        loadTransitions();
    }

    private void loadTransitions() {
        TransitionSet set = new TransitionSet()
                .addTransition(new Scale(0.7f))
                .addTransition(new Fade())
                .setInterpolator(new FastOutSlowInInterpolator());
        TransitionManager.beginDelayedTransition(container, set);
    }

}
