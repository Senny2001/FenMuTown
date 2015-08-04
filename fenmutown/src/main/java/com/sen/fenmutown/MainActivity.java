package com.sen.fenmutown;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.sen.fenmutown.fragment.LauncherFragment;

/**
 * Created by Black_Horse on 2015/7/29.
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        loadLauncher();
    }

    private void loadLauncher() {
        LauncherFragment baseFragment = new LauncherFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.launcher, baseFragment);
        ft.commit();
    }

}
