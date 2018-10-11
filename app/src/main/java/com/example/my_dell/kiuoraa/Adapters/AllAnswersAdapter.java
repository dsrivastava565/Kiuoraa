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

public class AllAnswersAdapter extends RecyclerView.Adapter<AllAnswersAdapter.view_holder> {
    Context context;
    Gson gson;
    List<ResponseDashboard> responseDashboards;
    int Positin;

    public AllAnswersAdapter(Context context, List<ResponseDashboard> responseDashboards, int Position) {
        this.responseDashboards = responseDashboards;
        this.context = context;
        gson = new Gson();
        this.Positin = Position;
    }

    @NonNull
    @Override
    public AllAnswersAdapter.view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_answers_recycler, parent, false);
        return new AllAnswersAdapter.view_holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AllAnswersAdapter.view_holder holder, int position) {
    holder.qustion.setText(responseDashboards.get(position).getAnswer().get(0).getAnswer());
    }

    @Override
    public int getItemCount() {
        return responseDashboards.get(Positin).getAnswer().size();
    }

    public class view_holder extends RecyclerView.ViewHolder {
        @BindView(R.id.allans)
        TextView qustion;

        public view_holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

