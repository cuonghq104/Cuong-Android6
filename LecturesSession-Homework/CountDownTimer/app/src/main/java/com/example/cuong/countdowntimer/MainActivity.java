package com.example.cuong.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    TextView txtvTime;

    EditText edtMin;

    EditText edtSec;

    Button btnStart;

    Button btnStop;

    private CountDownTimer countDownTimer;

    int timeLeft;

    private boolean isStop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReference();
        if (savedInstanceState != null) {
            timeLeft = savedInstanceState.getInt("TIME_LEFT");

            countDownTimer = new CountDownTimer(timeLeft, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long secondsUntilsFinished = millisUntilFinished / 1000;
                    txtvTime.setText(String.format("%02d : %02d", secondsUntilsFinished / 60, secondsUntilsFinished % 60) );
                    timeLeft-=1000;
                    isStop = false;
                }

                @Override
                public void onFinish() {
                    txtvTime.setText("BANG");
                    timeLeft = 0;
                    countDownTimer = null;
                    isStop = true;
                }
            }.start();
        }
        setupUI();
        addListener();
    }

    private void addListener() {

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStop) {
                    int time = 0;
                    if (timeLeft != 0) {
                        time = timeLeft;
                    } else {
                        int min = Integer.parseInt(edtMin.getText().toString());
                        int sec = Integer.parseInt(edtSec.getText().toString());
                        time = min * 60 + sec;
                        time = time * 1000;
                        timeLeft = time;
                    }
                    countDownTimer = new CountDownTimer(time, 1000) {

                        public void onTick(long millisUntilFinished) {
                            long secondsUntilsFinished = millisUntilFinished / 1000;
                            txtvTime.setText(String.format("%02d : %02d", secondsUntilsFinished / 60, secondsUntilsFinished % 60));
                            timeLeft -= 1000;
                            isStop = false;
                        }

                        public void onFinish() {
                            txtvTime.setText("BANG");
                            timeLeft = 0;
                            countDownTimer = null;
                            isStop = true;
                        }

                    }.start();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                isStop = true;
            }
        });
    }

    private void setupUI() {
    }

    private void getReference() {
        txtvTime = (TextView) findViewById(R.id.txtv_time);
        edtMin = (EditText) findViewById(R.id.edt_min);
        edtSec = (EditText) findViewById(R.id.edt_sec);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TIME_LEFT", timeLeft);
        Log.d(TAG, "onSaveInstanceState");
    }
}
