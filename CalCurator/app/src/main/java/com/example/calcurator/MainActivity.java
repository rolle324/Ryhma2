package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {
    private String date;
    private String meal;
    private int calories;
    private String stringCalories;
    private SaveMeal save = new SaveMeal();
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); //From stackoverflow.com
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator recommendation = Calculator.getInstance();

        loadDays();
        loadRecommendation();

        TextView tvRecommendation = (TextView) findViewById(R.id.tvRecommendation);
        tvRecommendation.setText(Integer.toString(recommendation.getRecommendation()));

        EditText inputDate = (EditText) findViewById(R.id.inputDate);
        //https://stackoverflow.com/questions/17672150/how-to-show-current-date-in-edittext-view
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        inputDate.setText(dateFormat.format(new Date()));

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
        if(this.date.isEmpty()) {
            this.date = "empty";
        }
        this.meal = inputMeal.getText().toString();
        if(this.meal.isEmpty()) {
            this.meal = "empty";
        }
        this.stringCalories = inputCalories.getText().toString();
        if(this.stringCalories.isEmpty()) {
            this.calories = 0;
        } else {
            this.calories = Integer.parseInt(this.stringCalories);
        }

        TextView tv = (TextView) findViewById(R.id.tvMealWarning);
        if(this.date.contains("empty") || this.meal.contains("empty") || this.calories == 0) {
            tv.setText("Täytä kaikki kohdat.");
        } else {
            save.saveMeal(date, meal, calories);
            updateCalories();
            tv.setText("Ateria tallennettu.");
        }
    }

    /**
     * Moves to Main Activity
     * @param view
     */
    public void goToCalcurator(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Moves to History
     * @param view
     */
    public void goToHistory(View view) {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

    /**
     * Moves to settings
     * @param view
     */
    public void goToSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    /**
     * Updates calorie intake TextView
     */
    public void updateCalories() {
        BookOfDays days = BookOfDays.getInstance();
        TextView tvIntake = (TextView) findViewById(R.id.tvIntake);

        //Gets total calories of last item on the ArrayList. Sets it to 0 if the list is empty.
        if (days.getAllDays().isEmpty()) {
            tvIntake.setText("0");
        } else {
            int i = days.getAllDays().size() - 1;
            tvIntake.setText(Integer.toString(days.getDay(i).getCalories()));
        }
    }

    /**
     * Saves calorie recommendation and list of days on pause
     */
    @Override
    protected void onPause() {
        super.onPause();
        Calculator recommendation = Calculator.getInstance();
        BookOfDays days = BookOfDays.getInstance();
        String jsonDays = gson.toJson(days.getAllDays());

        SharedPreferences prefPut = getSharedPreferences("Save", Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putInt("Recommendation", recommendation.getRecommendation());
        prefEditor.putString("Days", jsonDays);
        prefEditor.commit();
    }

    /**
     * Gets list of days from shared preferences
     */
    public void loadDays() {
        SharedPreferences prefGet = getSharedPreferences("Save", Activity.MODE_PRIVATE);
        String jsonDays = prefGet.getString("Days", "null");
        if (!jsonDays.equals("null")) {
            //From lecture 5 slideshow
            TypeToken<List<Day>> token = new TypeToken<List<Day>>() {};
            List<Day> allDays = gson.fromJson(jsonDays, token.getType());
            BookOfDays days = BookOfDays.getInstance();
            days.setAllDays(allDays);
        }
    }

    /**
     * Gets recommendation from shared preferences
     */
    public void loadRecommendation() {
        Calculator recommendation = Calculator.getInstance();

        //Loads calorie recommendation
        if (recommendation.getRecommendation() == 0) {
            SharedPreferences prefGet = getSharedPreferences("Save", Activity.MODE_PRIVATE);
            recommendation.setRecommendedCalories(prefGet.getInt("Recommendation", 0));
            //Goes to user data collection if recommendation is still 0
            if (recommendation.getRecommendation() == 0) {
                Intent intent = new Intent(this, GenderSelection.class);
                startActivity(intent);
            }
        }
    }
}