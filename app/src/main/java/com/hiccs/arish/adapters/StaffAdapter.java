package com.hiccs.arish.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.activities.NewsDetailsActivity;
import com.hiccs.arish.activities.StaffDetailsActivity;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StaffAdapter extends Adapter<StaffAdapter.ViewHolder> {

    private Context staffcontext;
    private List<StaffModel> staff_List;

    public StaffAdapter(Context context, List<StaffModel> staff_List) {

        this.staffcontext = context;
        this.staff_List = staff_List;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(staffcontext).inflate(R.layout.staff_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.staff_name.setText(staff_List.get(position).getDrName());
        Glide.with(staffcontext)
                .load(staff_List.get(position).getImgUrl())
                .into(holder.staff_img);

    }

    @Override
    public int getItemCount() {
        return staff_List == null ? 0 : staff_List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.staff_name)
        TextView staff_name;
        @BindView(R.id.staff_img)
        ImageView staff_img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @OnClick(R.id.listItemStaff)
        public void onStaffClick() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startStaffDetailsWithTransition();
            } else {
                startStaffDetailsActivity();
            }
        }


        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void startStaffDetailsWithTransition() {
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation((Activity) staffcontext,
                    staff_img, staff_img.getTransitionName()).toBundle();
            Intent intent = new Intent(staffcontext, StaffDetailsActivity.class);
            intent.putExtra(Constants.Staff_SELECTED_INTENT_KEY, staff_List.get(getAdapterPosition()));
            staffcontext.startActivity(intent, bundle);
        }

        private void startStaffDetailsActivity() {
            Intent intent = new Intent(staffcontext, StaffDetailsActivity.class);
            intent.putExtra(Constants.Staff_SELECTED_INTENT_KEY, staff_List.get(getAdapterPosition()));
            staffcontext.startActivity(intent);
        }
    }


}
