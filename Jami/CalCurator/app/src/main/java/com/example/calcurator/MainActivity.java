package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calculator recommendation = Calculator.getInstance();
        if (recommendation.getRecommendation() == 0) {
            Intent intent = new Intent(this, GenderSelection.class);
            startActivity(intent);
        }
        TextView tv = (TextView) findViewById(R.id.tvRecommendation);
        tv.setText(Integer.toString(recommendation.getRecommendation()));
    }


}