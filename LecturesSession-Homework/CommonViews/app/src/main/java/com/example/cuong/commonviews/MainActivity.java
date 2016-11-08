package com.example.cuong.commonviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    ImageView imgvWorld;
    CheckBox cbVerify;
    Button btSimple;
    Spinner spnCareer;
    RadioButton rdbtAsia, rdbtAfrica, rdbtEurope, rdbtAustralia, rdbtAmerica;
    RatingBar rtbrEnjoyLife;
    TextView txtvRating;
    SeekBar skbrSalary;
    TextView txtvSalary;
    SearchView svSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReference();
        initUI();
        addListener();
    }

    private void addListener() {
        btSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbVerify.setChecked(!cbVerify.isChecked());
            }
        });

        rtbrEnjoyLife.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtvRating.setText(String.format("%s stars", rtbrEnjoyLife.getRating()));
            }
        });

        skbrSalary.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtvSalary.setText(String.format("%d USD", progress * 1000));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        svSimple.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                svSimple.clearFocus();
                svSimple.setQuery("", false);
                svSimple.setIconified(true);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }

    private void initUI() {
        imgvWorld.setImageResource(R.drawable.world);
        Vector<String>careerVector = new Vector<>();
        careerVector.add("Doctor");
        careerVector.add("Nurse");
        careerVector.add("Teacher");
        careerVector.add("Engineer");
        careerVector.add("Worker");
        careerVector.add("Designer");
        careerVector.add("Programmer");

        ArrayAdapter<String>careerAdapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                careerVector
        );


        spnCareer.setAdapter(careerAdapter);

        skbrSalary.setProgress(50);
        txtvSalary.setText(String.format("%d USD", skbrSalary.getProgress() * 1000));
    }

    private void getReference() {
        imgvWorld = (ImageView) findViewById(R.id.imgv_world);
        cbVerify = (CheckBox) findViewById(R.id.cb_verify);
        btSimple = (Button) findViewById(R.id.bt_simple);
        spnCareer = (Spinner) findViewById(R.id.spn_career);
        rdbtAfrica = (RadioButton) findViewById(R.id.rdbt_africa);
        rdbtAmerica = (RadioButton) findViewById(R.id.rdbt_america);
        rdbtAsia = (RadioButton) findViewById(R.id.rdbt_asia);
        rdbtAustralia = (RadioButton) findViewById(R.id.rdbt_australia);
        rdbtEurope = (RadioButton) findViewById(R.id.rdbt_europe);
        rtbrEnjoyLife = (RatingBar) findViewById(R.id.rtbr_enjoy_life);
        txtvRating = (TextView) findViewById(R.id.txtv_rating);
        skbrSalary = (SeekBar) findViewById(R.id.skbr_salary);
        txtvSalary = (TextView) findViewById(R.id.txtv_salary);
        svSimple = (SearchView) findViewById(R.id.sv_simple);
    }


}
