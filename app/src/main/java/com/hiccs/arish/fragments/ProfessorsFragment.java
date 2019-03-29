package com.hiccs.arish.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hiccs.arish.R;
import com.hiccs.arish.adapters.StaffAdapter;
import com.hiccs.arish.models.StaffModel;

import java.util.ArrayList;
import java.util.List;


public class ProfessorsFragment extends Fragment  {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_professors,
                container, false);



        /*RecyclerView recyclerView =View.findViewById(R.id.staff_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<StaffModel> userList = new ArrayList<>();
        userList.add(new StaffModel(getString(R.string.), getString(R.string.yunus_desc), R.drawable.yunus));
        userList.add(new StaffModel(getString(R.string.nanoname), getString(R.string.nano_desc), R.drawable.nano));



        StaffAdapter StaffAdapter = new StaffAdapter(new ArrayList<StaffModel>(List));

        recyclerView.setAdapter(StaffAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/
        return view;
    }




}