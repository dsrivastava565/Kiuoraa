package com.example.my_dell.kiuoraa.Activities;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.my_dell.kiuoraa.BottomNavigationViewHelper;
import com.example.my_dell.kiuoraa.Fragments.AskaQuestion;
import com.example.my_dell.kiuoraa.Fragments.DashboardFragment;
import com.example.my_dell.kiuoraa.Fragments.PreviousQuestion;
import com.example.my_dell.kiuoraa.Fragments.profile;
import com.example.my_dell.kiuoraa.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_dashboard:
                replaceFragment(new DashboardFragment());
                break;
            case R.id.navigation_attendance:
                replaceFragment(new AskaQuestion());
                break;
            case R.id.navigation_leave:
                replaceFragment(new PreviousQuestion());
                break;
            case R.id.navigation_grievance:
                replaceFragment(new profile());
                break;
            }
        return true;
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setDefaultProgressBar(defaultProgressBar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        replaceFragment(new DashboardFragment());
        getSupportFragmentManager()
                .addOnBackStackChangedListener(
                        () -> updateBottomNavigationTitle(getSupportFragmentManager().findFragmentById(R.id.container))
                );

    }

    public void updateBottomNavigationTitle(Fragment f) {
        String className = f.getClass().getName();
        if (className.equals(DashboardFragment.class.getName()))
            navigation.getMenu().getItem(0).setChecked(true);
        else if (className.equals(AskaQuestion.class.getName()))
            navigation.getMenu().getItem(1).setChecked(true);
        else if (className.equals(PreviousQuestion.class.getName()))
            navigation.getMenu().getItem(2).setChecked(true);
        else if (className.equals(profile.class.getName()))
            navigation.getMenu().getItem(3).setChecked(true);
    }



    private void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) {
            //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container, fragment, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        switch (item.getItemId()) {
//            case R.id.notifications:
//                intentWithoutFinish(NotificationsActivity.class);
//                break;
//            case R.id.account:
//                intentWithoutFinish(AccountActivity.class);
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        Log.e("qwer", count + "");
        if (count == 1) {
            this.finishAffinity();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

