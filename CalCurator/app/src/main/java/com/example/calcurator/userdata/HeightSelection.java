package com.example.calcurator.userdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calcurator.R;

public class HeightSelection extends AppCompatActivity {
    private int height;
    private String heightString;

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

        //Checking if the text field is empty.
        this.heightString = inputHeight.getText().toString();
        if (this.heightString.isEmpty()) {
            this.height = 0;
        } else {
            this.height = Integer.parseInt(this.heightString);
        }

        if (this.height == 0) {
            TextView tv = (TextView) findViewById(R.id.tvHeightWarning);
            tv.setText("Täytä kaikki kohdat.");
        } else {
            Calculator recommendation = Calculator.getInstance();
            recommendation.setHeight(this.height);
            Intent intent = new Intent(this, WeightSelection.class);
            startActivity(intent);
        }
    }
}