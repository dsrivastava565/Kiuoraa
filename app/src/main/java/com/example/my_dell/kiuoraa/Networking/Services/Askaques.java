package com.example.my_dell.kiuoraa.Networking.Services;

import com.example.my_dell.kiuoraa.Networking.Models.AddQuesRequest;
import com.example.my_dell.kiuoraa.Networking.Models.Askquestion;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Askaques {

    @POST("angulablogui/add/")
    Call<SignupResponse> askQues(@Body Askquestion object);
}
