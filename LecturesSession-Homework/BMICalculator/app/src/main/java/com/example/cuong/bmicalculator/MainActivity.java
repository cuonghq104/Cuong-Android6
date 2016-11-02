package com.example.cuong.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    TextView tvWeight;
    TextView tvHeight;

    EditText etWeight;
    EditText etHeight;

    Button btCalculate;

    TextView tvResult;

    private boolean isShowingResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReference();
        init();
        addListener();
    }

    private void init() {
        etHeight.setText(getString(R.string.cm));
        etWeight.setText(getString(R.string.kg));
    }

    private void addListener() {
        etHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etHeight.setText("");
            }
        });

        etWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etWeight.setText("");
            }
        });

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowingResult) {
                    try {
                        int weight = Integer.parseInt(etWeight.getText().toString());
                        int height = Integer.parseInt(etHeight.getText().toString());
                        double heightByMeters = ((double) height) / 100;

                        double bmiCalculatingResult = ((double) weight) / (heightByMeters * heightByMeters);
                        String result = "";
                        if (bmiCalculatingResult < 16) {
                            result = getString(R.string.severelyUnderweight);
                        } else if (bmiCalculatingResult < 18.5) {
                            result = getString(R.string.underweight);
                        } else if (bmiCalculatingResult < 25) {
                            result = getString(R.string.normal);
                        } else if (bmiCalculatingResult < 30) {
                            result = getString(R.string.overweight);
                        } else {
                            result = getString(R.string.obese);
                        }
                        tvResult.setText(result);
                        etWeight.setEnabled(false);
                        etHeight.setEnabled(false);
                        btCalculate.setText("Again");
                        isShowingResult = true;
                    } catch (NumberFormatException e) {
                        Log.d(TAG, e.getLocalizedMessage());
                    }

                } else {
                    etWeight.setEnabled(true);
                    etHeight.setEnabled(true);
                    btCalculate.setText("Calculate");
                    tvResult.setText("");
                    isShowingResult = false;
                }
            }
        });

    }

    private void getReference() {
        tvHeight = (TextView) findViewById(R.id.tv_height);
        tvWeight = (TextView) findViewById(R.id.tv_weight);
        etWeight = (EditText) findViewById(R.id.et_weight);
        etHeight = (EditText) findViewById(R.id.et_height);
        btCalculate = (Button) findViewById(R.id.bt_calculator);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }


}
