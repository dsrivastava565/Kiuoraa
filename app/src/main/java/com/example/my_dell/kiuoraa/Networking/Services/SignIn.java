package com.example.my_dell.kiuoraa.Networking.Services;

import com.example.my_dell.kiuoraa.Networking.Models.SignupRequest;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;
import com.example.my_dell.kiuoraa.Signup;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignIn {

    @POST("angulablogui/register/")
    Call<SignupResponse> send(@Body SignupRequest object);

}
