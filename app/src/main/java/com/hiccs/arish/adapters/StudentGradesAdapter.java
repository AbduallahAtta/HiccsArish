package com.hiccs.arish.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hiccs.arish.R;
import com.hiccs.arish.models.StudentGrades;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentGradesAdapter extends RecyclerView.Adapter<StudentGradesAdapter.ViewHolder> {
    private Context StudentGradesContext;
    private List<StudentGrades> StudentGradesList;

    public StudentGradesAdapter(Context context, List<StudentGrades> StudentGradesList) {
        this.StudentGradesContext = context;
        this.StudentGradesList = StudentGradesList;
    }


    @NonNull
    @Override
    public StudentGradesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(StudentGradesContext).inflate(R.layout.student_grades_item, parent,
                false);

        return new StudentGradesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentGradesAdapter.ViewHolder holder, int position) {


        holder.subject_name.setText(StudentGradesList.get(position).getName());
        holder.subject_full_mark.setText(StudentGradesList.get(position).getFullMark());
        holder.student_mark.setText(StudentGradesList.get(position).getScore());


    }

    @Override
    public int getItemCount() {
        return StudentGradesList == null ? 0 : StudentGradesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.subject_name)
        TextView subject_name;

        @BindView(R.id.subject_full_mark)
        TextView subject_full_mark;

        @BindView(R.id.student_mark)
        TextView student_mark;

        @BindView(R.id.student_grade)
        TextView student_grade;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }
    private void getgrade(List<StudentGrades> StudentGrades) {


    }



    }
