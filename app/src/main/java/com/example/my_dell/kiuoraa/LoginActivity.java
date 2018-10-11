package com.example.my_dell.kiuoraa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_dell.kiuoraa.Activities.BaseActivity;
import com.example.my_dell.kiuoraa.Activities.MainActivity;
import com.example.my_dell.kiuoraa.Networking.KiuoraApi;
import com.example.my_dell.kiuoraa.Networking.Models.LoginRequest;
import com.example.my_dell.kiuoraa.Networking.Models.LoginResponse;
import com.example.my_dell.kiuoraa.Networking.Services.Login;
import com.example.my_dell.kiuoraa.Utils.DbHandler;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.submit_login)
    Button submit_login;
    @BindView(R.id.signup)
    TextView signup;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    LoginRequest loginRequest;
    LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.signup)
    public void setSignup() {
        Intent intent = new Intent(getApplicationContext(), Signup.class);
        startActivity(intent);
    }

    @OnClick(R.id.submit_login)

    public void setSubmit_login() {

        loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        // putObjectInIntentExtras("LoginEmpId",loginResponse);
//        startActivity(intent);

        SharedPreferences.Editor editor = getSharedPreferences("get", MODE_PRIVATE).edit();
        Login login = KiuoraApi.createService(Login.class);
        Call<LoginResponse> call = login.login(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == 200) {
                    loginResponse = response.body();
                    Log.e("Reeee", new Gson().toJson(loginResponse));
                    if (loginResponse.getMsg().equals("invalid credentials")) {
                        Toast.makeText(getApplicationContext(), "Wrong Details Entered", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        editor.putInt("idName", loginResponse.getUniq_id());
                        editor.apply();
                        startActivity(intent);

                    }

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });


    }
}
