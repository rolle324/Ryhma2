package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HeightSelection extends AppCompatActivity {
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height_selection);
    }

    /**
     * Adds users height to the recommendation singleton.
     */
    public void saveHeight(View view) {
        EditText inputHeight = (EditText) findViewById(R.id.inputHeight);
        height = Integer.parseInt(inputHeight.getText().toString());
        Calculator recommendation = Calculator.getInstance();
        recommendation.setHeight(height);

        Intent intent = new Intent(this, WeightSelection.class);
        startActivity(intent);
    }
}