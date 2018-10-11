package com.example.my_dell.kiuoraa.Networking.Services;

import com.example.my_dell.kiuoraa.Networking.Models.ResponseDashboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyQues {
    @GET("angulablogui/my_ques_view_all/")
    Call<List<ResponseDashboard>> myques(@Query("uniq_id") int value);
}
