package com.example.my_dell.kiuoraa.Networking.Api;

import com.example.my_dell.kiuoraa.LoginActivity;
import com.example.my_dell.kiuoraa.Networking.KiuoraApi;
import com.example.my_dell.kiuoraa.Networking.Models.SignupRequest;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;
import com.example.my_dell.kiuoraa.Networking.Services.SignIn;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AccountApi {
    private static AccountApi sInstance;

    public static AccountApi getInstance() {
        if (sInstance == null) {
            sInstance = new AccountApi();
        }
        return sInstance;
    }
//    public Observable<SignupResponse> sendTicket(SignupRequest object){
//        return KiuoraApi.getRetrofit(false).create(SignIn.class).sendTicket(object)
//                .observeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
}