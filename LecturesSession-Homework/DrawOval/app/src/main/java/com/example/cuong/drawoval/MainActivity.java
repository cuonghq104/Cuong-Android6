package com.example.cuong.drawoval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.dsb_simple)
    DiscreteSeekBar dsbSimple;

    @BindView(R.id.tv_value)
    TextView tvValue;

    @BindView(R.id.bt_tap_me)
    Button btTapMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addListener();
    }

    private void addListener() {
        dsbSimple.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                tvValue.setText(String.format("%02d", value));
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
    }

    @OnClick(R.id.bt_tap_me)
    public void onClick() {
        int currentProgress = dsbSimple.getProgress();
        int progress = currentProgress + 5;
        progress = progress % 100;

        dsbSimple.setProgress(progress);
        tvValue.setText(String.format("%02d", progress));
    }
}
