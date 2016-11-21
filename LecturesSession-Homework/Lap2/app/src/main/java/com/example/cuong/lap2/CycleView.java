package com.example.cuong.lap2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Cuong on 11/20/2016.
 */
public class CycleView extends View{

    Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CycleView(Context context) {
        super(context);
    }

    public CycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CycleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(0, 0, getWidth(), getHeight(), p);
    }
}
