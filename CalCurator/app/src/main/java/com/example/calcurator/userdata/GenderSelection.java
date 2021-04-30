package com.example.calcurator.userdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.calcurator.R;
import com.example.calcurator.userdata.AgeSelection;
import com.example.calcurator.userdata.Calculator;

public class GenderSelection extends AppCompatActivity {
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_selection);
    }

    /**
     * Adds users gender to the recommendation singleton.
     * @param view
     */
    public void saveGender(View view) {
        RadioGroup rgGender = (RadioGroup) findViewById(R.id.radioGenderSettings);

        if (rgGender.getCheckedRadioButtonId() == R.id.radioMale) {
            this.gender = "male";
        } else if(rgGender.getCheckedRadioButtonId() == R.id.radioFemale) {
            this.gender = "female";
        } else {
            this.gender = "null";
        }

        if(this.gender != "null") {
            Calculator recommendation = Calculator.getInstance(); //Viittaus singletoniin.
            recommendation.setGender(this.gender);
            Intent nextActivity = new Intent(this, AgeSelection.class);
            startActivity(nextActivity);
        }
    }
}