package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class ActivitySelection extends AppCompatActivity {
    private double activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }

    /**
     * Adds activity level to recommendation singleton.
     * @param view
     */
    public void saveGender(View view) {
        RadioGroup radioActivityLevel = (RadioGroup) findViewById(R.id.radioActivityLevel);

        if (radioActivityLevel.getCheckedRadioButtonId() == R.id.radio1) {
            this.activity = 1.2;
        } else if (radioActivityLevel.getCheckedRadioButtonId() == R.id.radio2) {
            this.activity = 1.375;
        } else if (radioActivityLevel.getCheckedRadioButtonId() == R.id.radio3) {
            this.activity = 1.55;
        } else if (radioActivityLevel.getCheckedRadioButtonId() == R.id.radio4) {
            this.activity = 1.725;
        } else if (radioActivityLevel.getCheckedRadioButtonId() == R.id.radio5) {
            this.activity = 1.9;
        } else {
            this.activity = 0;
        }

        if (this.activity != 0) {
            Calculator recommendation = Calculator.getInstance(); //Viittaus singletoniin.
            recommendation.setActivity(this.activity);
            recommendation.calculate();
            Intent nextActivity = new Intent(this, MainActivity.class);
            startActivity(nextActivity);
        }
    }
}