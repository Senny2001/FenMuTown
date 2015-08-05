package com.sen.fenmutown.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.sen.fenmutown.R;

/**
 * Created by Senny on 2015/8/5.
 */
public class LauncherIcon extends FrameLayout {
    public LauncherIcon(Context context) {
        super(context);
    }

    public LauncherIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LauncherIcon(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LauncherCircle launcherCircle = (LauncherCircle)findViewById(R.id.launcher_circle);
        if (launcherCircle != null && (launcherCircle.getCircleLeft() == 0 ||
                launcherCircle.getCircleTop() == 0 || launcherCircle.getCircleRadius() == 0)) {
            View luncherTwiiter = findViewById(R.id.launcher_twitter);
            launcherCircle.reset(luncherTwiiter.getLeft() + 0.0f, luncherTwiiter.getTop() + 0.0f, (luncherTwiiter.getWidth() + 0.0f) / 2);
        }
    }
}
