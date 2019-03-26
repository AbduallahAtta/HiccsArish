package com.hiccs.arish.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.models.ExtraCoursesModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        holder.extra_course_des.setText(Extra_Courses_List.get(position).getDescription());
        Glide.with(ExtraCoursesContext).load(Extra_Courses_List.get(position).getImgUrl()).into(holder.extra_course_img);

    }

    @Override
    public int getItemCount() {
        return Extra_Courses_List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.extra_course_name)
        TextView extra_course_name;
        @BindView(R.id.extra_course_des)
        TextView extra_course_des;
        @BindView(R.id.extra_course_img)
        ImageView extra_course_img;


        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
