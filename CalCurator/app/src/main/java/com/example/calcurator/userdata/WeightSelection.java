package com.example.calcurator.userdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calcurator.R;
import com.example.calcurator.userdata.ActivitySelection;
import com.example.calcurator.userdata.Calculator;

public class WeightSelection extends AppCompatActivity {
    private int weight;
    private String weightString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_selection);
    }

    /**
     * Adds users weight to the recommendation singleton.
     */
    public void saveWeight(View view) {
        EditText inputWeight = (EditText) findViewById(R.id.inputWeight);

        //Checking if the text field is empty.
        this.weightString = inputWeight.getText().toString();
        if (this.weightString.isEmpty()) {
            this.weight = 0;
        } else {
            this.weight = Integer.parseInt(this.weightString);
        }

        if (this.weight == 0) {
            TextView tv = (TextView) findViewById(R.id.tvWeightWarning);
            tv.setText("Täytä kaikki kohdat.");
        } else {
            Calculator recommendation = Calculator.getInstance();
            recommendation.setWeight(this.weight);
            Intent intent = new Intent(this, ActivitySelection.class);
            startActivity(intent);
        }
    }
}