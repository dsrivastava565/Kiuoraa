package com.example.my_dell.kiuoraa.Fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_dell.kiuoraa.Adapters.DashboardAdapter;
import com.example.my_dell.kiuoraa.Networking.KiuoraApi;
import com.example.my_dell.kiuoraa.Networking.Models.LoginResponse;
import com.example.my_dell.kiuoraa.Networking.Models.ResponseDashboard;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;
import com.example.my_dell.kiuoraa.Networking.Services.DashboardAns;
import com.example.my_dell.kiuoraa.Networking.Services.SignIn;
import com.example.my_dell.kiuoraa.R;
import com.example.my_dell.kiuoraa.Utils.DbHandler;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class DashboardFragment extends BaseFragment {

    @BindView(R.id.remainingLeave)
    RecyclerView recyclerView;
    Gson gson = new Gson();
    Calendar calendar = Calendar.getInstance();
    LoginResponse loginResponse1;
    SharedPreferences sharedPreferences;
List<ResponseDashboard> responseDashboard = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, rootView);
       sharedPreferences = this.getActivity().getSharedPreferences("get",MODE_PRIVATE);
       int sendUniq = sharedPreferences.getInt("idName",0);
        DashboardAns signIn = KiuoraApi.createService(DashboardAns.class);
        Call<List<ResponseDashboard>> call = signIn.view();
        call.enqueue(new Callback<List<ResponseDashboard>>() {
            @Override
            public void onResponse(Call<List<ResponseDashboard>> call, Response<List<ResponseDashboard>> response) {
                if (response.code()==200){
                    Log.e("done",new Gson().toJson(response.body()));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(new DashboardAdapter(getContext(),response.body(),sendUniq));
                    recyclerView.setNestedScrollingEnabled(false);

                }
            }

            @Override
            public void onFailure(Call<List<ResponseDashboard>> call, Throwable t) {
                Toast.makeText(getContext(),"Wrong Details Entered",Toast.LENGTH_SHORT).show();
            }
        });


       // setView();
        hideDefaultProgress();

        return rootView;

    }
//    public void setView(){
//        DashboardAns signIn = KiuoraApi.createService(DashboardAns.class);
//        Call<ResponseDashboard> call = signIn.view();
//        call.enqueue(new Callback<ResponseDashboard>() {
//            @Override
//            public void onResponse(Call<ResponseDashboard> call, Response<ResponseDashboard> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseDashboard> call, Throwable t) {
//
//            }
//        });
//
//    }
}
