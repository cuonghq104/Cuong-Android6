package com.example.cuong.lap2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Cuong on 11/20/2016.
 */
public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
//        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
//
//        int widthSize = parentWidth / 2;
//        int widthMode = MeasureSpec.EXACTLY;
//
//        int width = MeasureSpec.makeMeasureSpec(widthSize, widthMode);
//        super.onMeasure(width, parentHeight);
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int myWidth = (int) (parentWidth * 0.5);
        super.onMeasure(MeasureSpec.makeMeasureSpec(myWidth, MeasureSpec.EXACTLY), heightMeasureSpec);

    }
}
