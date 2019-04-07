package com.hiccs.arish.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hiccs.arish.R;
import com.hiccs.arish.adapters.StaffAdapter;
import com.hiccs.arish.models.StaffModel;
import com.hiccs.arish.rest.APIUtils;
import com.hiccs.arish.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AssistantsFragment extends Fragment {
    @BindView(R.id.assistant_fragment_recycler)
    RecyclerView AssistantRecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_assistants, container, false);
        AssistantRecyclerView = view.findViewById(R.id.assistant_fragment_recycler);
        ButterKnife.bind(view);
        StaffData();
        return view;
    }

    private void StaffData() {
        logger("Started to fetch staff");
        APIUtils.getHiccsAPI().Assistants()
                .enqueue(new Callback<List<StaffModel>>() {
                    @Override
                    public void onResponse(Call<List<StaffModel>> call, Response<List<StaffModel>> response) {
                        logger("Started to get response");

                        if (response.isSuccessful()) {
                            linkstaffAdapter(response.body());

                            logger(response.body().get(0).toString());
                            logger(response.body().get(0).getDrName());
                        } else {
                            logger("response code = " + response.code());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<StaffModel>> call, Throwable t) {
                        logger(t.getMessage());
                    }
                });
    }

    private void logger(String s) {
        Log.v(Constants.NETWORK_TAG, s);
        Log.v("HiccsArish", s);
    }

    private void linkstaffAdapter(List<StaffModel> body) {
        StaffAdapter adapter = new StaffAdapter(getContext(), body);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        AssistantRecyclerView.setLayoutManager(linearLayoutManager);
        AssistantRecyclerView.setAdapter(adapter);
    }


}