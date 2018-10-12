package com.example.my_dell.kiuoraa.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.my_dell.kiuoraa.Activities.MainActivity;
import com.example.my_dell.kiuoraa.Adapters.AllAnswersAdapter;
import com.example.my_dell.kiuoraa.Networking.KiuoraApi;
import com.example.my_dell.kiuoraa.Networking.Models.AddQuesRequest;
import com.example.my_dell.kiuoraa.Networking.Models.ResponseDashboard;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;
import com.example.my_dell.kiuoraa.Networking.Services.AddquesRequest;
import com.example.my_dell.kiuoraa.R;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreviousQuesAndAnsBottomsheet extends BottomSheetDialogFragment {
    AddQuesRequest addQuesRequest;
    List<ResponseDashboard> responseDashboard;
    int position;
    @BindView(R.id.send12)
    Button send;
    @BindView(R.id.recylerView)
    RecyclerView recyclerView;
    @BindView(R.id.enterdans)
    EditText editText;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ques_ans, container, false);
        ButterKnife.bind(this, rootView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AllAnswersAdapter(getContext(),responseDashboard,position));
        recyclerView.setNestedScrollingEnabled(false);

        return rootView;
    }


    public void getData(AddQuesRequest addQuesRequest, List<ResponseDashboard> responseDashboard, int position) {
        this.addQuesRequest = addQuesRequest;
        this.responseDashboard = responseDashboard;
        this.position = position;
    }
    @OnClick(R.id.send12)
    public void setAddQuesRequest(){

        addQuesRequest.setAnswer(editText.getText().toString());
                AddquesRequest login = KiuoraApi.createService(AddquesRequest.class);
               Call<SignupResponse> call = login.addques(addQuesRequest);
                call.enqueue(new Callback<SignupResponse>() {
                    @Override
                   public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                       if (response.code() == 200) {
                            Toast.makeText(getContext(), "Succesfully Entered", Toast.LENGTH_SHORT).show();
                           Intent in = new Intent(getContext(), MainActivity.class);
                            startActivity(in);

                        }
                    }

                  @Override
                   public void onFailure(Call<SignupResponse> call, Throwable t) {
                       Toast.makeText(getContext(), " Some Error Occured", Toast.LENGTH_SHORT).show();
                    }
                });
    }




}



