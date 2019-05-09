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

        View itemView = LayoutInflater.from(StudentInformationsContext).inflate(R.layout.student_info_item, parent, false);

        return new StudentInformationsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentInformationsAdapter.ViewHolder holder, int position) {

        holder.StudentId.setText(StudentInformationsList.get(position).getStudentID());
        holder.FullName.setText(StudentInformationsList.get(position).getFullName());
        holder.AcademicYear.setText(StudentInformationsList.get(position).getAcademicYear());
        holder.Department.setText(StudentInformationsList.get(position).getDepartment());
        holder.Phone.setText(StudentInformationsList.get(position).getPhone());
        holder.Address.setText(StudentInformationsList.get(position).getAddress());
        Glide.with(StudentInformationsContext).load(StudentInformationsList.get(position).getImgUrl())
                .into(holder.profile_image);

    }

    @Override
    public int getItemCount() {
        return StudentInformationsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.user_id)
        TextView StudentId;
        @BindView(R.id.FullNameTextView)
        TextView FullName;
        @BindView(R.id.AcademicYearTextView)
        TextView AcademicYear;
        @BindView(R.id.DepartmentTextView)
        TextView Department;
        @BindView(R.id.GenderTextView)
        TextView Gender;
        @BindView(R.id.PhoneTextView)
        TextView Phone;
        @BindView(R.id.AddressTextView)
        TextView Address;
        @BindView(R.id.profile_image)
        ImageView profile_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
