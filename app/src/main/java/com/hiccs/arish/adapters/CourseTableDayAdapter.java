package com.hiccs.arish.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hiccs.arish.R;
import com.hiccs.arish.models.coursestable.CourseTime;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AbdullahAtta on 2/28/2019.
 */
public class CourseTableDayAdapter extends RecyclerView.Adapter<CourseTableDayAdapter.CoursesTableDayViewHolder> {

    private CourseTime[] mCourseTimes;
    private Context mContext;

    public CourseTableDayAdapter(CourseTime[] mCourseTimes, Context mContext) {
        this.mCourseTimes = mCourseTimes;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public CoursesTableDayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View courseTimeView = LayoutInflater.from(mContext).inflate(R.layout.list_item_table_course_time, viewGroup, false);
        return new CoursesTableDayViewHolder(courseTimeView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesTableDayViewHolder holder, int i) {
        CourseTime day = mCourseTimes[i];
        if (!day.isInDay()) {
            hideViews(holder);
        } else {
            showDay(holder, day);
        }
    }

    private void showDay(@NonNull CoursesTableDayViewHolder holder, CourseTime day) {
        holder.courseName.setText(day.getCourseName());
        holder.profName.setText(day.getProfName());
        holder.duration.setText(day.getCourseDuration());
    }

    private void hideViews(@NonNull CoursesTableDayViewHolder holder) {
        holder.courseName.setVisibility(View.GONE);
        holder.profName.setVisibility(View.GONE);
        holder.duration.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mCourseTimes == null ? 0 : mCourseTimes.length;
    }

    public class CoursesTableDayViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.listItemCourseTimeNameLabel)
        TextView courseName;
        @BindView(R.id.listItemCourseTimeProfNameLabel)
        TextView profName;
        @BindView(R.id.listItemCourseTimeDurationLabel)
        TextView duration;

        public CoursesTableDayViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
