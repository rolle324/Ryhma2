package com.example.calcurator.history;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Day {

    //Instanssimuuttujat
    private int totalCalories = 0;
    private String date;
    private String allMeals = "";



    //Rakentaja
    public Day(String date, String meal, int calories) {
        Calendar calendar = Calendar.getInstance();     // Hakee ajan millon ruoka on laitettu
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        String dateTime = simpleDateFormat.format(calendar.getTime());

        this.date = date;
        this.allMeals = meal + ": " + calories + " kcal " + dateTime + "\n\n";
        this.totalCalories = this.totalCalories + calories;
    }

    //Metodit

    /**
     * Adds a meal to the object.
     * @param meal
     * @param calories
     */
    public void addMeal(String meal, int calories) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        String dateTime = simpleDateFormat.format(calendar.getTime());

        this.allMeals = this.allMeals + meal + ": " + calories + " kcal " + dateTime + "\n\n" ;
        this.totalCalories = totalCalories + calories;
    }

    /**
     * Returns date.
     * @return
     */
    public String getDate(){
        return this.date;
    }

    /**
     * Returns total calories of the day.
     * @return
     */
    public int getCalories(){
        return this.totalCalories;
    }

    /**
     * Returns all meals of the day.
     * @return
     */
    public String getAllMeals() {
        return this.allMeals;
    }

    /**
     * Returns date and total calories.
     * @return
     */
    @Override
    public String toString() {
        return this.date + ": " + this.totalCalories + " kcal";
    }
}


