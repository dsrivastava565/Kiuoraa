package com.example.my_dell.kiuoraa.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_dell.kiuoraa.R;

import butterknife.ButterKnife;

public class AskaQuestion extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ask_question, container, false);
        ButterKnife.bind(this, rootView);

        
        return rootView;
    }
}
