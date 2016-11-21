package com.example.cuong.drawoval;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Cuong on 11/20/2016.
 */
public class CircleView extends View {
    Paint p = new Paint();

    int color;

//    Color defaultColor = Color.BLACK;

    public CircleView(Context context) {
        super(context);
        initFrom(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFrom(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFrom(context, attrs);
    }

    private void initFrom(Context context, AttributeSet attrs) {
        if (attrs == null)
            return;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);

        color = typedArray.getColor(R.styleable.CircleView_circle_color, -1);

        typedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(color);
        canvas.drawOval(0, 0, getWidth(), getHeight(), p);
    }
}
