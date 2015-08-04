package com.sen.fenmutown.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sen.fenmutown.R;

/**
 * Created by Black_Horse on 2015/7/29.
 */
public class LauncherFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_launcher, null);

        return view;
    }
}
