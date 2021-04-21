package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AgeSelection extends AppCompatActivity {
    private int age;

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
        this.age = Integer.parseInt(inputAge.getText().toString());
        Calculator recommendation = Calculator.getInstance();
        recommendation.setAge(age);

        Intent intent = new Intent(this, HeightSelection.class);
        startActivity(intent);
    }
}