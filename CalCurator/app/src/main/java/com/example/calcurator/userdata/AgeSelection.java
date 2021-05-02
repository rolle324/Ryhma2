package com.example.calcurator.userdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calcurator.R;

public class AgeSelection extends AppCompatActivity {
    private int age;
    private String ageString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_selection);
    }

    /**
     * Adds users age to the recommendation singleton.
     * @param view
     */
    public void saveAge(View view) {
        EditText inputAge = (EditText) findViewById(R.id.inputAge);

        //Checking if the text field is empty.
        this.ageString = inputAge.getText().toString();
        if (this.ageString.isEmpty()) {
            this.age = 0;
        } else {
            this.age = Integer.parseInt(this.ageString);
        }

        if (this.age == 0) {
            TextView tv = (TextView) findViewById(R.id.tvAgeWarning);
            tv.setText("Täytä kaikki kohdat.");
        } else {
            Calculator recommendation = Calculator.getInstance();
            recommendation.setAge(this.age);
            Intent intent = new Intent(this, HeightSelection.class);
            startActivity(intent);
        }
    }
}