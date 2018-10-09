package com.example.my_dell.kiuoraa.Application;

import android.app.Application;

import com.example.my_dell.kiuoraa.Utils.DbHandler;
import com.example.my_dell.kiuoraa.Utils.Utils;



/**
 * Created by Anurag on 5/10/17.
 */

public class MyApplication extends Application {
    public static MyApplication context;

    public static MyApplication getAppContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        DbHandler.initialize(this);
        Utils.initialize(this);
    }
}