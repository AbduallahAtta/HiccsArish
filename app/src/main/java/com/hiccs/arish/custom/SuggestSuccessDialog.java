package com.hiccs.arish.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.activities.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AbdullahAtta on 5/7/2019.
 */
public class SuggestSuccessDialog {
    @BindView(R.id.dialogSuggestSuccessDialogImage)
    ImageView dialogSuggestSuccessDialogImage;
    private Dialog dialog;
    private Activity mActivity;

    public void showSuggestSuccessDialog(Activity activity) {
        mActivity = activity;
        dialog = new Dialog(mActivity);
        dialog.setContentView(R.layout.dialog_suggest_success);
        ButterKnife.bind(this, dialog);
        loadDialogImage();
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    private void loadDialogImage() {
        Glide.with(mActivity)
                .load(R.drawable.message_gif)
                .into(dialogSuggestSuccessDialogImage);
    }

    @OnClick(R.id.dialogSuggestSuccessDialogButton)
    public void onViewClicked() {
        dialog.dismiss();
        startHomeActivity();
    }

    private void startHomeActivity() {
        Intent intent = new Intent(mActivity.getApplicationContext(), HomeActivity.class);
        mActivity.startActivity(intent);
        mActivity.finish();
    }
}
