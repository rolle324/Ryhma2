package com.example.calcurator.userdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.calcurator.R;
import com.example.calcurator.userdata.ActivitySelection;
import com.example.calcurator.userdata.Calculator;

public class WeightSelection extends AppCompatActivity {
    private int weight;
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
        weight = Integer.parseInt(inputWeight.getText().toString());
        Calculator recommendation = Calculator.getInstance();
        recommendation.setWeight(weight);

        Intent intent = new Intent(this, ActivitySelection.class);
        startActivity(intent);
    }
}