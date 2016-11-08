package com.example.cuong.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txtvOnCreate;

    private TextView txtvOnDestroy;

    private TextView txtvOnResume;

    private TextView txtvOnPause;

    private TextView txtvOnStart;

    private TextView txtvOnStop;

    private TextView txtvOnRestart;

    private int numberOfOnCreateCalled = 0;
    private int numberOfOnStartCalled = 0;
    private int numberOfOnResumeCalled = 0;
    private int numberOfOnRestartCalled = 0;
    private int numberOfOnPauseCalled = 0;
    private int numberOfOnStopCalled = 0;
    private int numberOfOnDestroyCalled = 0;

    private static final String NUMBER_OF_ON_CREATE_CALLED = "ON_CREATE";
    private static final String NUMBER_OF_ON_START_CALLED = "ON_START";
    private static final String NUMBER_OF_ON_RESUME_CALLED = "ON_RESUME";
    private static final String NUMBER_OF_ON_RESTART_CALLED = "ON_RESTART";
    private static final String NUMBER_OF_ON_PAUSE_CALLED = "ON_PAUSE";
    private static final String NUMBER_OF_ON_STOP_CALLED = "ON_STOP";
    private static final String NUMBER_OF_ON_DESTROY_CALLED = "ON_DESTROY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getReference();
        if (savedInstanceState != null) {
            numberOfOnCreateCalled = savedInstanceState.getInt(NUMBER_OF_ON_CREATE_CALLED);
            numberOfOnStartCalled = savedInstanceState.getInt(NUMBER_OF_ON_START_CALLED);
            numberOfOnDestroyCalled = savedInstanceState.getInt(NUMBER_OF_ON_DESTROY_CALLED);
            numberOfOnStopCalled = savedInstanceState.getInt(NUMBER_OF_ON_STOP_CALLED);
            numberOfOnRestartCalled = savedInstanceState.getInt(NUMBER_OF_ON_RESTART_CALLED);
            numberOfOnResumeCalled = savedInstanceState.getInt(NUMBER_OF_ON_RESUME_CALLED);
            numberOfOnPauseCalled = savedInstanceState.getInt(NUMBER_OF_ON_CREATE_CALLED);
        }
        setupUI();
        numberOfOnCreateCalled++;
//        txtvOnCreate.setText(String.format("OnCreate : %d", numberOfOnCreateCalled));
    }

    private void setupUI() {
        txtvOnCreate.setText(String.format("OnCreate : %d", numberOfOnCreateCalled));
        txtvOnStart.setText(String.format("OnStart : %d", numberOfOnStartCalled));
        txtvOnResume.setText(String.format("OnResume : %d", numberOfOnResumeCalled));
        txtvOnRestart.setText(String.format("OnRestart : %d", numberOfOnRestartCalled));
        txtvOnPause.setText(String.format("OnPause : %d", numberOfOnPauseCalled));
        txtvOnStop.setText(String.format("OnStop : %d", numberOfOnStopCalled));
        txtvOnDestroy.setText(String.format("OnDestroy : %d", numberOfOnDestroyCalled));
//        txtvOnCreate.setText();
    }

    private void getReference() {
        txtvOnCreate = (TextView) findViewById(R.id.txtv_on_create_act2);
        txtvOnStart = (TextView) findViewById(R.id.txtv_on_start_act2);
        txtvOnResume = (TextView) findViewById(R.id.txtv_on_resume_act2);
        txtvOnRestart = (TextView) findViewById(R.id.txtv_on_restart_act2);
        txtvOnPause = (TextView) findViewById(R.id.txtv_on_pause_act2);
        txtvOnStop = (TextView) findViewById(R.id.txtv_on_stop_act2);
        txtvOnDestroy = (TextView) findViewById(R.id.txtv_on_destroy_act2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        numberOfOnStartCalled++;
        txtvOnStart.setText(String.format("OnStart : %d", numberOfOnStartCalled));
    }

    @Override
    protected void onResume() {
        super.onResume();
        numberOfOnResumeCalled++;
        txtvOnResume.setText(String.format("OnResume : %d", numberOfOnResumeCalled));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        numberOfOnRestartCalled++;
        txtvOnRestart.setText(String.format("OnRestart : %d", numberOfOnRestartCalled));
    }

    @Override
    protected void onPause() {
        super.onPause();
        numberOfOnPauseCalled++;
        txtvOnPause.setText(String.format("OnPause : %d", numberOfOnPauseCalled));
    }

    @Override
    protected void onStop() {
        super.onStop();
        numberOfOnStopCalled++;
        txtvOnStop.setText(String.format("OnStop : %d", numberOfOnStopCalled));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        numberOfOnDestroyCalled++;
        txtvOnDestroy.setText(String.format("OnDestroy : %d", numberOfOnDestroyCalled));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUMBER_OF_ON_CREATE_CALLED, numberOfOnCreateCalled);
        outState.putInt(NUMBER_OF_ON_DESTROY_CALLED, numberOfOnDestroyCalled);
        outState.putInt(NUMBER_OF_ON_PAUSE_CALLED, numberOfOnPauseCalled);
        outState.putInt(NUMBER_OF_ON_RESTART_CALLED, numberOfOnRestartCalled);
        outState.putInt(NUMBER_OF_ON_RESUME_CALLED, numberOfOnResumeCalled);
        outState.putInt(NUMBER_OF_ON_START_CALLED, numberOfOnStartCalled);
        outState.putInt(NUMBER_OF_ON_STOP_CALLED, numberOfOnStopCalled);
    }
}
