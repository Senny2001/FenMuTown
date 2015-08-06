package com.sen.fenmutown;

import android.app.PendingIntent;
import android.app.Service;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.sen.fenmutown.fragment.IntroductionFragment;
import com.sen.fenmutown.fragment.LauncherFragment;
import com.sen.fenmutown.utils.FragmentControler;

/**
 * Created by Senny on 2015/7/29.
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        loadLauncher();
        findViewById(R.id.launcher).postDelayed(new Runnable() {
            @Override
            public void run() {
                IntroductionFragment baseFragment = new IntroductionFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                FragmentControler.replaceByAnimation(ft, R.id.launcher, baseFragment, null,
                        R.anim.alpha_gradient_in, R.anim.alpha_gradient_out, 0, 0);
            }
        }, 3 * 1000);
    }

    private void loadLauncher() {
        LauncherFragment baseFragment = new LauncherFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentControler.add(ft, R.id.launcher, baseFragment, null);
    }

}
