package com.hiccs.arish.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hiccs.arish.R;
import com.hiccs.arish.models.StaffModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        holder.staff_des.setText(staff_List.get(position).getDescription());
        Glide.with(staffcontext).load(staff_List.get(position).getImgUrl()).into(holder.staff_img);

    }

    @Override
    public int getItemCount() {
        return staff_List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.staff_name)
        TextView staff_name;
        @BindView(R.id.staff_des)
        TextView staff_des;
        @BindView(R.id.staff_img)
        ImageView staff_img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
