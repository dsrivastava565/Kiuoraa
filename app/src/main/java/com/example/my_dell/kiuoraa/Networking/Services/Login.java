package com.example.my_dell.kiuoraa.Networking.Services;

import com.example.my_dell.kiuoraa.Networking.Models.LoginRequest;
import com.example.my_dell.kiuoraa.Networking.Models.LoginResponse;
import com.example.my_dell.kiuoraa.Networking.Models.SignupRequest;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Login {

    @POST("angulablogui/login/")
    Call<LoginResponse> login(@Body LoginRequest object);


}
