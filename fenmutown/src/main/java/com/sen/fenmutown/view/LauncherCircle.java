package com.sen.fenmutown.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Senny on 2015/8/5.
 */
public class LauncherCircle extends View {

    private final int INT_MOVE_ANGLE_OFFSET = 2;
    private final int INT_SWEEP_TARGET_ANGLE = 70;

    private float fltCircleLeft;
    private float fltCircleTop;
    private float fltCircleRadius;
    private float fltStroke = 6;
    private float fltRatioArc = (float) (2 * Math.PI / 360);
    private int intAngleOffset = 0;
    private int intSweepAngle = 90;
    private int intStartAngle1 = -10;
    private int intStartAngle2 = 80;
    private int intStartAngle3 = 170;
    private int intStartAngle4 = 260;
    private boolean isBlnAnimation = false;
    private boolean isBlnRotateCircle = false;
    private boolean isBlnFirstInvalidate = true;
    private Paint circlePaint;
    private RectF circleRectF;

    public float getCircleLeft() {
        return fltCircleLeft;
    }

    public float getCircleTop() {
        return fltCircleTop;
    }

    public float getCircleRadius() {
        return fltCircleRadius;
    }

    public LauncherCircle(Context context) {
        super(context);
    }

    public LauncherCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LauncherCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        circlePaint = new Paint();
        circlePaint.setStrokeWidth(fltStroke);
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setColor(Color.RED);
    }

    public void reset(float left, float top, float radius) {
        this.fltCircleLeft = left - fltStroke;
        this.fltCircleTop = top - fltStroke;
        this.fltCircleRadius = radius;
        if (fltCircleLeft != 0 && fltCircleTop != 0 && fltCircleRadius != 0) {
            circleRectF = new RectF(fltCircleLeft, fltCircleTop, fltCircleLeft + fltCircleRadius * 2 + fltStroke * 2,
                    fltCircleTop + fltCircleRadius * 2 + fltStroke * 2);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawArc(canvas, intStartAngle1 + intAngleOffset, intSweepAngle);
        drawArc(canvas, intStartAngle2 + intAngleOffset, intSweepAngle);
        drawArc(canvas, intStartAngle3 + intAngleOffset, intSweepAngle);
        drawArc(canvas, intStartAngle4 + intAngleOffset, intSweepAngle);

        if (isBlnAnimation) {
            if (isBlnRotateCircle) {
                if (intAngleOffset >= 90) {
                    intAngleOffset = INT_MOVE_ANGLE_OFFSET;
                } else {
                    intAngleOffset += INT_MOVE_ANGLE_OFFSET;
                }
                invalidate();
            }
            if ((intSweepAngle - INT_MOVE_ANGLE_OFFSET) >= INT_SWEEP_TARGET_ANGLE) {
                intSweepAngle -= INT_MOVE_ANGLE_OFFSET;
                intStartAngle1 += INT_MOVE_ANGLE_OFFSET;
                intStartAngle2 += INT_MOVE_ANGLE_OFFSET;
                intStartAngle3 += INT_MOVE_ANGLE_OFFSET;
                intStartAngle4 += INT_MOVE_ANGLE_OFFSET;
                if (isBlnFirstInvalidate) {
                    isBlnFirstInvalidate = false;
                    postInvalidateDelayed(500);
                } else {
                    invalidate();
                }
            } else if (intSweepAngle == INT_SWEEP_TARGET_ANGLE) {
                isBlnRotateCircle = true;
                invalidate();
            }
        }
    }

    private void drawArc(Canvas canvas, int startAngle, int sweepAngle) {
        if (canvas != null && circlePaint != null && circleRectF != null) {
            canvas.drawArc(circleRectF, startAngle, sweepAngle, false, circlePaint);
            circlePaint.setStyle(Paint.Style.FILL);
            float radius = (circleRectF.right - circleRectF.left) / 2;
            float startCenterX = circleRectF.centerX() + (float) (radius * Math.cos(fltRatioArc * startAngle));
            float startCenterY = circleRectF.centerY() + (float) (radius * Math.sin(fltRatioArc * startAngle));
            canvas.drawCircle(startCenterX, startCenterY, fltStroke / 2, circlePaint);
            float endCenterX = circleRectF.centerX() + (float) (radius * Math.cos(fltRatioArc * (startAngle + sweepAngle)));
            float endCenterY = circleRectF.centerY() + (float) (radius * Math.sin(fltRatioArc * (startAngle + sweepAngle)));
            canvas.drawCircle(endCenterX, endCenterY, fltStroke / 2, circlePaint);
            circlePaint.setStyle(Paint.Style.STROKE);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        isBlnRotateCircle = false;
        circlePaint = null;
        circleRectF = null;
    }
}
