package com.example.cuong.lap2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Cuong on 11/20/2016.
 */
public class MyCompoundView extends RelativeLayout {

    @BindView(R.id.tv_value)
    TextView tvValue;

    @BindView(R.id.tv_unit)
    TextView tvUnit;

    @BindView(R.id.bt_add)
    Button btAdd;

    @BindView(R.id.bt_subtract)
    Button btSubtract;

    public MyCompoundView(Context context) {
        super(context);
        initFrom(context, null);
    }

    public MyCompoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFrom(context, attrs);
    }

    public MyCompoundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFrom(context, attrs);
    }

    public void initFrom(Context context, AttributeSet attrs) {
        View rootView = inflate(context, R.layout.my_compound_view,this);
        ButterKnife.bind(this, rootView);

        if (attrs == null)
            return;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCompoundView);

        int value = typedArray.getInt(R.styleable.MyCompoundView_value, -1);
        String unit = typedArray.getString(R.styleable.MyCompoundView_unit);

        tvValue.setText(String.format("%d", value));
        tvUnit.setText(unit);

        typedArray.recycle();
    }

    @OnClick(R.id.bt_add)
    public void onClick() {
        int value = Integer.parseInt(tvValue.getText().toString());
        tvValue.setText(String.format("%d", value + 1));
    }

    @OnClick(R.id.bt_subtract)
    public void OnClick() {
        int value = Integer.parseInt(tvValue.getText().toString());
        tvValue.setText(String.format("%d", value - 1));
    }


}
