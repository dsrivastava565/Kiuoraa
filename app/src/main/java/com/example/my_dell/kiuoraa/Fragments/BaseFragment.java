package com.example.my_dell.kiuoraa.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.my_dell.kiuoraa.Activities.BaseActivity;
import com.example.my_dell.kiuoraa.Networking.Models.LoginResponse;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class BaseFragment extends Fragment {

    public Observable<Connectivity> networkObservable;
    List<Disposable> disposables;

    public BaseFragment() {
        disposables = new ArrayList<>();
    }

    public void intentWithFinish(Class cls) {
        ((BaseActivity) getActivity()).intentWithFinish(cls);
    }

    public void intentWithoutFinish(Class cls) {
        ((BaseActivity) getActivity()).intentWithoutFinish(cls);
    }

    public void putObjectInIntentExtras(String key, Object obj) {
        ((BaseActivity) getActivity()).putObjectInIntentExtras(key, obj);
    }

//    public <T> T getObjectFromIntentExtras(String key, Object classOfT) {
//        return ((BaseActivity) getActivity()).getObjectFromIntentExtras(key, classOfT);
//    }

    public Bundle getIntentExtras() {
        return ((BaseActivity) getActivity()).getIntentExtras();
    }

    public MaterialDialog getProgressBar() {
        return ((BaseActivity) getActivity()).getProgressBar();
    }

    public void alert(String title, String content, int type) {
        ((BaseActivity) getActivity()).alert(title, content, type);
    }

    public void handleNetworkErrors(Throwable e, int type) {
        ((BaseActivity) getActivity()).handleNetworkErrors(e, type);
    }

    public void showDefaultProgress() {
        ((BaseActivity) getActivity()).showDefaultProgress();
    }

    public void hideDefaultProgress() {
        ((BaseActivity) getActivity()).hideDefaultProgress();
    }

    @Override
    public void onResume() {
        super.onResume();
        networkObservable = ((BaseActivity) getActivity()).networkObservable;
    }
    public void setVectorForPreLollipop(TextView textView, int resourceId, Context activity) {
        ((BaseActivity) getActivity()).setVectorForPreLollipop(textView, resourceId, activity);
    }
    @Override
    public void onPause() {
        super.onPause();
        hideDefaultProgress();
        for (Disposable disposable : disposables) {
            if (disposable != null && !disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
