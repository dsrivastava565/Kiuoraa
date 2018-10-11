package com.example.my_dell.kiuoraa.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.my_dell.kiuoraa.Activities.MainActivity;
import com.example.my_dell.kiuoraa.Networking.KiuoraApi;
import com.example.my_dell.kiuoraa.Networking.Models.Askquestion;
import com.example.my_dell.kiuoraa.Networking.Models.LoginResponse;
import com.example.my_dell.kiuoraa.Networking.Models.SignupResponse;
import com.example.my_dell.kiuoraa.Networking.Services.Askaques;
import com.example.my_dell.kiuoraa.Networking.Services.Login;
import com.example.my_dell.kiuoraa.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class AskaQuestion extends BaseFragment {
    @BindView(R.id.askaques)
    EditText askaques;
    @BindView(R.id.category)
    Spinner category;
    @BindView(R.id.submit_ques)
    Button submit_ques;
    List<String> c;
    Askquestion askquestion;
    SharedPreferences sharedPreferences;
   int cat_value;
    int sendUniq;
    String check;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ask_question, container, false);
        ButterKnife.bind(this, rootView);
        setCategory();
        sharedPreferences = this.getActivity().getSharedPreferences("get",MODE_PRIVATE);
        sendUniq = sharedPreferences.getInt("idName",0);
        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             cat_value = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return rootView;
    }

    public void setCategory() {
        c = new ArrayList<>();
        c.add(0, "academics");
        c.add(1, "sports");
        c.add(2, "fest");
        c.add(2, "placement");
        c.add(2, "club");
        c.add(2, "others");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, c);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

    }
    @OnClick(R.id.submit_ques)
    public void setSubmit_ques() {
        askquestion = new Askquestion();
        askquestion.setQuestion(askaques.getText().toString());
        askquestion.setCategory(c.get(cat_value));
        askquestion.setAdd_by(sendUniq);
        Log.e("hey", new Gson().toJson(askquestion));
        check = askaques.getText().toString();
        if (check.matches("")) {
            Toast.makeText(getContext(), "You did not enter a Question", Toast.LENGTH_SHORT).show();
             return;
        } else {
            Askaques login = KiuoraApi.createService(Askaques.class);
            Call<SignupResponse> call = login.askQues(askquestion);
            call.enqueue(new Callback<SignupResponse>() {
                @Override
                public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                    Toast.makeText(getContext(), "Question Asked Successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<SignupResponse> call, Throwable t) {

                }
            });

        }
    }

}
