package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    private String gender;
    private String ageString;
    private int age;
    private String heightString;
    private int height;
    private String weightString;
    private int weight;
    private double activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    /**
     * Saves all settings to singleton and tells the user if the operation was successful.
     * @param view
     */
    public void save(View view) {
        RadioGroup rgGender = (RadioGroup) findViewById(R.id.radioGenderSettings);

        if (rgGender.getCheckedRadioButtonId() == R.id.radioMaleSettings) {
            this.gender = "male";
        } else if(rgGender.getCheckedRadioButtonId() == R.id.radioFemaleSettings) {
            this.gender = "female";
        } else {
            this.gender = "null";
        }

        EditText inputAge = (EditText) findViewById(R.id.inputAgeSettings);
        this.ageString = inputAge.getText().toString();
        if (this.ageString.isEmpty()) {
            this.age = 0;
        } else {
            this.age = Integer.parseInt(this.ageString);
        }

        EditText inputHeight = (EditText) findViewById(R.id.inputHeightSettings);
        this.heightString = inputHeight.getText().toString();
        if (this.heightString.isEmpty()) {
            this.height = 0;
        } else {
            this.height = Integer.parseInt(this.heightString);
        }

        EditText inputWeight = (EditText) findViewById(R.id.inputWeightSettings);
        this.weightString = inputWeight.getText().toString();
        if (this.weightString.isEmpty()) {
            this.weight = 0;
        } else {
            this.weight = Integer.parseInt(this.weightString);
        }

        RadioGroup rgActivity = (RadioGroup) findViewById(R.id.radioActivitySettings);

        if (rgActivity.getCheckedRadioButtonId() == R.id.radioLevel1) {
            this.activity = 1.2;
        } else if (rgActivity.getCheckedRadioButtonId() == R.id.radioLevel2) {
            this.activity = 1.375;
        } else if (rgActivity.getCheckedRadioButtonId() == R.id.radioLevel3) {
            this.activity = 1.55;
        } else if (rgActivity.getCheckedRadioButtonId() == R.id.radioLevel4) {
            this.activity = 1.725;
        } else if (rgActivity.getCheckedRadioButtonId() == R.id.radioLevel5) {
            this.activity = 1.9;
        } else {
            this.activity = 0;
        }

        Calculator recommendation = Calculator.getInstance();
        recommendation.setAll(this.gender, this.age, this.height, this.weight, this.activity);
        recommendation.calculate();

        TextView tv = (TextView) findViewById(R.id.tvConfirmation);
        if (recommendation.getRecommendation() != 0) {
            tv.setText("Asetukset tallennettu.");
        } else {
            tv.setText("Täytä kaikki kohdat");
        }

        System.out.println(recommendation);
    }

    /**
     * Go to MainActivity.
     */
    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Go to History.
     */
    public void goToHistory(View view) {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }
}