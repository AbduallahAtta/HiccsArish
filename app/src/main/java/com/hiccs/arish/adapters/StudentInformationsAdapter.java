package com.hiccs.arish.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hiccs.arish.R;
import com.hiccs.arish.models.StudentAccountModel;

import java.util.List;

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

//        holder.StudentId.setText(StudentInformationsList.get(position).getId());
//        holder.FullName.setText(StudentInformationsList.get(position).getFullName());
//        holder.Gender.setText(StudentInformationsList.get(position).getGender());
//        holder.AcademicYear.setText(StudentInformationsList.get(position).getAcademicYear());
//        holder.Department.setText(StudentInformationsList.get(position).getDepartment());
//        holder.Phone.setText(StudentInformationsList.get(position).getPhone());
//        holder.Address.setText(StudentInformationsList.get(position).getAddress());
//        holder.AcademicSemester.setText(StudentInformationsList.get(position).getAcademicSemester());

        /* Glide.with(StudentInformationsContext).load(StudentInformationsList.get(position).getImgUrl()).into(holder.staff_img);
         */
    }

    @Override
    public int getItemCount() {
        return StudentInformationsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // TODO: 3/24/2019 bind the correct view to the corresponding id

        /**
         * @BindView(R.id.staff_recycler) TextView StudentId;
         * @BindView(R.id.staff_recycler) TextView FullName;
         * @BindView(R.id.staff_recycler) TextView Gender;
         * @BindView(R.id.staff_recycler) TextView AcademicYear;
         * @BindView(R.id.staff_recycler) TextView Department;
         * @BindView(R.id.staff_recycler) TextView Phone;
         * @BindView(R.id.staff_recycler) TextView Address;
         * @BindView(R.id.staff_recycler) TextView AcademicSemester;
         * /**
         * <p>
         * /*   @BindView(R.id.img)
         * ImageView _img;
         */


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);
        }
    }
}
