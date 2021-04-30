package com.example.calcurator.history;

import java.util.ArrayList;

public class Day {

    //INSTANSSIMUUTTUJAT
    //private String meal;
    //private int calories;
    private int totalCalories = 0;
    private String date;
    private String allMeals = "";


    //RAKENTAJA
    public Day(String date, String meal, int calories) {
        this.date = date;
        this.allMeals = meal + ": " + calories + "\n";
        this.totalCalories = this.totalCalories + calories;
    }

    //METODIT
    public void addMeal(String meal, int calories) {
        this.allMeals = this.allMeals + meal + ": " + calories + "\n";
        this.totalCalories = totalCalories + calories;
    }
    public String getDate(){
        return this.date;
    }

    public int getCalories(){
        return this.totalCalories;
    }

    public String getAllMeals() {
        return this.allMeals;
    }

    @Override
    public String toString() {
        return this.date + ": " + this.totalCalories + " cal";
    }
}


