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
import com.hiccs.arish.models.StudentAccountModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentInformationsAdapter extends RecyclerView.Adapter<StudentInformationsAdapter.ViewHolder> {
    private Context StudentInformationsContext;
    private List<StudentAccountModel> StudentInformationsList;

    public StudentInformationsAdapter(Context context, List<StudentAccountModel> StudentInformationsList) {

        this.StudentInformationsContext = context;
        this.StudentInformationsList = StudentInformationsList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(StudentInformationsContext).inflate(R.layout.staff_item, parent, false);

        return new StudentInformationsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentInformationsAdapter.ViewHolder holder, int position) {

        holder.StudentId.setText(StudentInformationsList.get(position).getId());
        holder.FullName.setText(StudentInformationsList.get(position).getFullName());
        holder.Gender.setText(StudentInformationsList.get(position).getGender());
        holder.AcademicYear.setText(StudentInformationsList.get(position).getAcademicYear());
        holder.Department.setText(StudentInformationsList.get(position).getDepartment());
        holder.Phone.setText(StudentInformationsList.get(position).getPhone());
        holder.Address.setText(StudentInformationsList.get(position).getAddress());
        holder.AcademicSemester.setText(StudentInformationsList.get(position).getAcademicSemester());

       /* Glide.with(StudentInformationsContext).load(StudentInformationsList.get(position).getImgUrl()).into(holder.staff_img);
       */
    }

    @Override
    public int getItemCount() {
        return StudentInformationsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.StudentId)
        TextView StudentId;
        @BindView(R.id.FullName)
        TextView FullName;
        @BindView(R.id.Gender)
        TextView Gender;
        @BindView(R.id.AcademicYear)
        TextView AcademicYear;
        @BindView(R.id.Department)
        TextView Department;
        @BindView(R.id.Phone)
        TextView Phone;
        @BindView(R.id.Address)
        TextView Address;
        @BindView(R.id.AcademicSemester)
        TextView AcademicSemester;


     /*   @BindView(R.id.img)
        ImageView _img;
        */


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
