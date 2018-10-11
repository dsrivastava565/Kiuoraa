package com.example.my_dell.kiuoraa.Adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.my_dell.kiuoraa.Activities.MainActivity;
import com.example.my_dell.kiuoraa.Fragments.PreviousQuesAndAnsBottomsheet;
import com.example.my_dell.kiuoraa.Networking.KiuoraApi;
import com.example.my_dell.kiuoraa.Networking.Models.AddQuesRequest;
import com.example.my_dell.kiuoraa.Networking.Models.LoginResponse;
import com.example.my_dell.kiuoraa.Networking.Models.ResponseDashboard;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;
import com.example.my_dell.kiuoraa.Networking.Services.AddquesRequest;
import com.example.my_dell.kiuoraa.Networking.Services.DashboardAns;
import com.example.my_dell.kiuoraa.Networking.Services.Login;
import com.example.my_dell.kiuoraa.R;
import com.example.my_dell.kiuoraa.Utils.DbHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.view_holder> {
    Context context;
    Gson gson;
    List<ResponseDashboard> responseDashboard;
    AddQuesRequest addQuesRequest;
    LoginResponse loginResponse;
    int sendUniq;

    public DashboardAdapter(Context context, List<ResponseDashboard> responseDashboard, int sendUniq) {
        this.context = context;
        gson = new Gson();
        this.responseDashboard = responseDashboard;
        addQuesRequest = new AddQuesRequest();
        loginResponse = new LoginResponse();
        this.sendUniq = sendUniq;
    }

    @NonNull
    @Override
    public DashboardAdapter.view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_recycler, parent, false);
        return new view_holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapter.view_holder holder, int position) {
        holder.qustion.setText("Question : " + responseDashboard.get(position).getQues().getQuestion()+"?");
        if (responseDashboard.get(position).getAnswer().size() == 0) {
            holder.answer.setTextColor(context.getResources().getColor(R.color.red));
            holder.answer.setText("Sorry No Answer");
        } else{
            holder.answeredby.setText("Answerd by :" + responseDashboard.get(position).getAnswer().get(0).getAddedByName());
            holder.answer.setText("Answer : " + responseDashboard.get(position).getAnswer().get(0).getAnswer());}

        Log.e("sendi", new Gson().toJson(responseDashboard.get(position).getQues().getQuesId()));


        holder.addQues.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addQuesRequest.setQuestion_id(responseDashboard.get(position).getQues().getQuesId());
                addQuesRequest.setUniq_id(sendUniq);

                FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
                PreviousQuesAndAnsBottomsheet bottomSheet = new PreviousQuesAndAnsBottomsheet();
                bottomSheet.getData(addQuesRequest, responseDashboard, position);
                bottomSheet.setCancelable(true);
                bottomSheet.show(manager, "TicketingDetail");


//                addQuesRequest.setAnswer("Hello");

//

            }
        });
    }


    @Override
    public int getItemCount() {
        return responseDashboard.size();
    }

    public class view_holder extends RecyclerView.ViewHolder {

        @BindView(R.id.Questionatdashboard)
        TextView qustion;
        @BindView(R.id.AnswerAtDashboard)
        TextView answer;
        @BindView(R.id.addQues)
        ImageView addQues;
        @BindView(R.id.answeredby)
        TextView answeredby;


        public view_holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
