package com.example.my_dell.kiuoraa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.my_dell.kiuoraa.Activities.BaseActivity;
import com.example.my_dell.kiuoraa.Networking.Api.AccountApi;
import com.example.my_dell.kiuoraa.Networking.KiuoraApi;
import com.example.my_dell.kiuoraa.Networking.Models.SignupRequest;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;
import com.example.my_dell.kiuoraa.Networking.Services.SignIn;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends BaseActivity {
    @BindView(R.id.number)
    EditText number;
    @BindView(R.id.dobsignup)
    EditText dob;
    @BindView(R.id.spinner_gender)
    Spinner gender;
    SelectDateFragment dateFragment;
    @BindView(R.id.namesignup)
    EditText name;
    @BindView(R.id.usernamesignup)
    EditText username;
    @BindView(R.id.passwordsignup)
    EditText password;
    @BindView(R.id.confirmpassword)
    EditText confirmpassword;
    @BindView(R.id.emailsignup)
    EditText email;
    @BindView(R.id.signupbtn)
    Button signup;
    int gender_value;
    SignupResponse newSIgn;
    public List<Disposable> disposables;
    List<String> c = new ArrayList<String>();
SignupRequest signupRequest;
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        dateFragment = new SelectDateFragment();
        dob.setText(sdf.format(new Date()));


        setGender();
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender_value = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @OnClick(R.id.dobsignup)
    public void setDate() {
        Calendar calendar = Calendar.getInstance();
        dob.setClickable(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dob.setClickable(true);
            }
        }, 500);

        dateFragment.show(getSupportFragmentManager(), sdf.format(calendar.getTime()), dob, "1990-01-01", sdf.format(calendar.getTime()));


    }

    public void setGender() {

        c.add(0, "Select");
        c.add(1, "M");
        c.add(2, "F");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, c);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

    }

    @OnClick(R.id.signupbtn)
    public void setSignup() {
        signupRequest = new SignupRequest();
        signupRequest.setName(name.getText().toString());
        signupRequest.setUsername(username.getText().toString());
        signupRequest.setEmail(email.getText().toString());
        signupRequest.setMobile(Integer.valueOf(number.getText().toString()));
        signupRequest.setPassword(password.getText().toString());
        signupRequest.setGender(c.get(gender_value));
        String ps = password.getText().toString();
        String cf = confirmpassword.getText().toString();
        if (ps.equals(cf)) {

            Log.e("sign", new Gson().toJson(signupRequest));
            SignIn signIn = KiuoraApi.createService(SignIn.class);
            Call<SignupResponse> call = signIn.send(signupRequest);
            call.enqueue(new Callback<SignupResponse>() {
                @Override
                public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                    if (response.code() == 200) {
                        newSIgn = response.body();
                        Log.e("Res", new Gson().toJson(newSIgn));
                        if (newSIgn.getName().equals("Username already taken")) {
                            Toast.makeText(getApplicationContext(), "Username Already exist", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Successfully Registerd", Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(getApplicationContext(), LoginActivity.class);

                            startActivity(in);
                        }

                    }
                }

                @Override
                public void onFailure(Call<SignupResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            });

        }
        else
            Toast.makeText(getApplicationContext(), "Passwords does not matched", Toast.LENGTH_LONG).show();
    }


    }


