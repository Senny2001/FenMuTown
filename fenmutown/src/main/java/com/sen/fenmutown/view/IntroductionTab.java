package com.sen.fenmutown.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.sen.fenmutown.R;

/**
 * Created by Senny on 2015/8/6.
 */
public class IntroductionTab extends View {

    private int intNumTabs;
    private Paint tabPaint;

    public IntroductionTab(Context context) {
        super(context);
    }

    public IntroductionTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.FenMu);
        float space = t.getDimension(R.styleable.FenMu_space, 11);
        System.out.println("Introduction "+space);
    }

    public IntroductionTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void reset(int intNumTabs) {
        this.intNumTabs = intNumTabs;
    }

    public void scrollTo(int index, float positionPercent) {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tabPaint = new Paint();
        tabPaint.setStyle(Paint.Style.STROKE);
        tabPaint.setStrokeWidth(2);
        tabPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < intNumTabs; i++) {
        }

    }

}
