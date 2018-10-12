package com.example.my_dell.kiuoraa.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_dell.kiuoraa.Networking.KiuoraApi;
import com.example.my_dell.kiuoraa.Networking.Models.ResponseDashboard;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;
import com.example.my_dell.kiuoraa.Networking.Services.MyQues;
import com.example.my_dell.kiuoraa.Networking.Services.SignIn;
import com.example.my_dell.kiuoraa.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class PreviousQuestion extends BaseFragment {
@BindView(R.id.reccc)
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_previousques, container, false);
        ButterKnife.bind(this, rootView);
        sharedPreferences = this.getActivity().getSharedPreferences("get", MODE_PRIVATE);

//        MyQues signIn = KiuoraApi.createService(MyQues.class);
//        Call<List<ResponseDashboard>> call = signIn.myques(sendUniq);
//        call.enqueue(new Callback<List<ResponseDashboard>>() {
//            @Override
//            public void onResponse(Call<List<ResponseDashboard>> call, Response<List<ResponseDashboard>> response) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                //recyclerView.setAdapter();
//            }
//
//            @Override
//            public void onFailure(Call<List<ResponseDashboard>> call, Throwable t) {
//
//            }
//        });


        return rootView;
    }
}
