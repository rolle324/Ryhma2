package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calcurator.history.BookOfDays;
import com.example.calcurator.history.Day;
import com.example.calcurator.history.SaveMeal;
import com.example.calcurator.userdata.Calculator;
import com.example.calcurator.userdata.GenderSelection;
import com.example.calcurator.userdata.Settings;

public class MainActivity extends AppCompatActivity {
    private String date;
    private String meal;
    private int calories;
    private SaveMeal save = new SaveMeal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calculator recommendation = Calculator.getInstance();
        recommendation.setRecommendedCalories(1000);
        if (recommendation.getRecommendation() == 0) {
            Intent intent = new Intent(this, GenderSelection.class);
            startActivity(intent);
        }
        TextView tv = (TextView) findViewById(R.id.tvRecommendation);
        tv.setText(Integer.toString(recommendation.getRecommendation()));
        System.out.println(recommendation);
    }
    
    public void saveDay(View view) {
        EditText inputDate = (EditText) findViewById(R.id.inputDate);
        EditText inputMeal = (EditText) findViewById(R.id.inpuMeal);
        EditText inputCalories = (EditText) findViewById(R.id.inputCalories);

        this.date = inputDate.getText().toString();
        this.meal = inputMeal.getText().toString();
        this.calories = Integer.parseInt(inputCalories.getText().toString());

        save.saveMeal(date, meal, calories);
    }

    public void goToSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}