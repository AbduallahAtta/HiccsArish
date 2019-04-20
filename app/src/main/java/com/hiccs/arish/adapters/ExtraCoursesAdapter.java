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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.activities.ExtraCoursesDetailsActivity;
import com.hiccs.arish.models.ExtraCoursesModel;
import com.hiccs.arish.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExtraCoursesAdapter extends RecyclerView.Adapter<ExtraCoursesAdapter.ViewHolder> {
    private Context ExtraCoursesContext;
    private List<ExtraCoursesModel> Extra_Courses_List;

    public ExtraCoursesAdapter(Context context, List<ExtraCoursesModel> Extra_Courses_List) {
        this.ExtraCoursesContext = context;
        this.Extra_Courses_List = Extra_Courses_List;
    }


    @NonNull
    @Override
    public ExtraCoursesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(ExtraCoursesContext).inflate(R.layout.extra_courses_item, parent,
                false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExtraCoursesAdapter.ViewHolder holder, int position) {


        holder.extra_course_name.setText(Extra_Courses_List.get(position).getCourseName());
        //  holder.extra_course_des.setText(Extra_Courses_List.get(position).getDescription());
        Glide.with(ExtraCoursesContext).load(Extra_Courses_List.get(position).getImgUrl())
                .into(holder.extra_course_img);

    }

    @Override
    public int getItemCount() {
        return Extra_Courses_List == null ? 0 : Extra_Courses_List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.extra_course_name)
        TextView extra_course_name;
        @BindView(R.id.extra_course_img)
        ImageView extra_course_img;


        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @OnClick(R.id.extraCoursesCardView)
        public void onCourseClick() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startExtraCoursesDetails();
            } else {
                startExtraCoursesDetailsActivity();
            }
        }


        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void startExtraCoursesDetails() {
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation((Activity) ExtraCoursesContext,
                    extra_course_img, extra_course_img.getTransitionName()).toBundle();
            Intent intent = new Intent(ExtraCoursesContext, ExtraCoursesDetailsActivity.class);
            intent.putExtra(Constants.EXTRA_COURSES_SELECTED_INTENT_KEY, Extra_Courses_List.get(getAdapterPosition()));
            ExtraCoursesContext.startActivity(intent, bundle);
        }

        private void startExtraCoursesDetailsActivity() {
            Intent intent = new Intent(ExtraCoursesContext, ExtraCoursesDetailsActivity.class);
            intent.putExtra(Constants.EXTRA_COURSES_SELECTED_INTENT_KEY, Extra_Courses_List.get(getAdapterPosition()));
            ExtraCoursesContext.startActivity(intent);
        }
    }


}
