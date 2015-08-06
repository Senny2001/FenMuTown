package com.sen.fenmutown.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Senny on 2015/8/6.
 */
public class FragmentControler {

    public static void add(FragmentTransaction ft, int layoutID,
                                   Fragment fragment, String tag) {
        addByAnimation(ft, layoutID, fragment, tag, 0, 0, 0, 0);
    }

    public static void addWidthStack(FragmentTransaction ft, int layoutID,
                                             Fragment fragment, String stack, String tag) {
        ft.addToBackStack(stack);
        ft.add(layoutID, fragment, tag);
        ft.commit();
    }

    public static void addByAnimation(FragmentTransaction ft, int layoutID,
                                   Fragment fragment, String tag, int enter, int exit, int popEnter, int popExit) {
        ft.setCustomAnimations(enter, exit, popEnter, popExit);
        ft.add(layoutID, fragment, tag);
        ft.commit();
    }

    public static void replace(FragmentTransaction ft, int layoutID,
                                   Fragment fragment, String tag) {
        replaceByAnimation(ft, layoutID, fragment, tag, 0, 0, 0, 0);
    }

    public static void replaceWidthStack(FragmentTransaction ft, int layoutID,
                                             Fragment fragment, String stack, String tag) {
        ft.addToBackStack(stack);
        ft.replace(layoutID, fragment, tag);
        ft.commit();
    }

    public static void replaceByAnimation(FragmentTransaction ft, int layoutID,
                                       Fragment fragment, String tag, int enter, int exit, int popEnter, int popExit) {
        ft.setCustomAnimations(enter, exit, popEnter, popExit);
        ft.replace(layoutID, fragment, tag);
        ft.commit();
    }

}
