package com.example.my_dell.kiuoraa.Networking.Services;

import com.example.my_dell.kiuoraa.Networking.Models.AddQuesRequest;
import com.example.my_dell.kiuoraa.Networking.Models.LoginRequest;
import com.example.my_dell.kiuoraa.Networking.Models.LoginResponse;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AddquesRequest {

    @POST("angulablogui/add_answer/")
    Call<SignupResponse> addques(@Body AddQuesRequest object);
}
