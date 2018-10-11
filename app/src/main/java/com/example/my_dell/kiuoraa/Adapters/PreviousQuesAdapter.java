package com.example.my_dell.kiuoraa.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_dell.kiuoraa.Networking.Models.AddQuesRequest;
import com.example.my_dell.kiuoraa.Networking.Models.LoginResponse;
import com.example.my_dell.kiuoraa.Networking.Models.ResponseDashboard;
import com.example.my_dell.kiuoraa.R;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PreviousQuesAdapter extends RecyclerView.Adapter<PreviousQuesAdapter.view_holder> {

    public PreviousQuesAdapter(Context context, List<ResponseDashboard> responseDashboard, int sendUniq) {

    }

    @NonNull
    @Override
    public PreviousQuesAdapter.view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_recycler, parent, false);
        return new PreviousQuesAdapter.view_holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PreviousQuesAdapter.view_holder holder, int position) {


    }


    @Override
    public int getItemCount() {
        return 0;
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
