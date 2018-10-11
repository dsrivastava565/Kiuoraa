package com.example.my_dell.kiuoraa.Networking.Services;

import com.example.my_dell.kiuoraa.Networking.Models.LoginRequest;
import com.example.my_dell.kiuoraa.Networking.Models.LoginResponse;
import com.example.my_dell.kiuoraa.Networking.Models.ResponseDashboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DashboardAns {

    @GET("angulablogui/view/")
    Call<List<ResponseDashboard>> view();
}
