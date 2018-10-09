package com.example.my_dell.kiuoraa.Networking.Api;

import com.example.my_dell.kiuoraa.LoginActivity;

import io.reactivex.Observable;

public class AccountApi {
    private static AccountApi sInstance;

    public static AccountApi getInstance() {
        if (sInstance == null) {
            sInstance = new AccountApi();
        }
        return sInstance;
    }
}