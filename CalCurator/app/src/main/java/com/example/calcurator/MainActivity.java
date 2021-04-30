package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calcurator.history.BookOfDays;
import com.example.calcurator.history.Day;
import com.example.calcurator.history.History;
import com.example.calcurator.history.SaveMeal;
import com.example.calcurator.userdata.Calculator;
import com.example.calcurator.userdata.GenderSelection;
import com.example.calcurator.userdata.Settings;

public class MainActivity extends AppCompatActivity {
    private String date;
    private String meal;
    private int calories;
    private SaveMeal save = new SaveMeal();
=======
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
>>>>>>> d25eda2e823eb6bb3159e3d3f057cb79aca19edf

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        Calculator recommendation = Calculator.getInstance();

        //Loads calorie recommendation
        if (recommendation.getRecommendation() == 0) {
            SharedPreferences prefGet = getSharedPreferences("SaveRecommendation", Activity.MODE_PRIVATE);
            recommendation.setRecommendedCalories(prefGet.getInt("Recommendation", 0));
            //Goes to user data collection if recommendation is still 0
            if (recommendation.getRecommendation() == 0) {
                Intent intent = new Intent(this, GenderSelection.class);
                startActivity(intent);
            }
        }

        TextView tvRecommendation = (TextView) findViewById(R.id.tvRecommendation);
        tvRecommendation.setText(Integer.toString(recommendation.getRecommendation()));
        updateCalories();
    }

    /**
     * Reads meal information and saves it to a day object
     * @param view
     */
    public void saveDay(View view) {
        EditText inputDate = (EditText) findViewById(R.id.inputDate);
        EditText inputMeal = (EditText) findViewById(R.id.inpuMeal);
        EditText inputCalories = (EditText) findViewById(R.id.inputCalories);

        this.date = inputDate.getText().toString();
        this.meal = inputMeal.getText().toString();
        this.calories = Integer.parseInt(inputCalories.getText().toString());

        save.saveMeal(date, meal, calories);
        updateCalories();
    }

    /**
     * Move to Main Activity
     * @param view
     */
    public void goToCalcurator(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Move to History
     * @param view
     */
    public void goToHistory(View view) {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

    /**
     * Move to settings
     * @param view
     */
=======
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

>>>>>>> d25eda2e823eb6bb3159e3d3f057cb79aca19edf
    public void goToSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
<<<<<<< HEAD

    /**
     * Updates calorie intake TextView
     */
    public void updateCalories() {
        BookOfDays days = BookOfDays.getInstance();
        TextView tvIntake = (TextView) findViewById(R.id.tvIntake);
        int i = days.getAllDays().size() - 1;
        tvIntake.setText(Integer.toString(days.getDay(i).getCalories()));
    }

    /**
     * Saves calorie recommendation on pause
     */
    @Override
    protected void onPause() {
        super.onPause();
        Calculator recommendation = Calculator.getInstance();

        SharedPreferences prefPut = getSharedPreferences("SaveRecommendation", Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt("Recommendation", recommendation.getRecommendation());
        prefEditor.commit();
    }
=======
>>>>>>> d25eda2e823eb6bb3159e3d3f057cb79aca19edf
}