package com.example.calcurator;

import android.app.Activity;
import android.widget.EditText;

public class Calculator {
    private static final Calculator recommendation = new Calculator();
    private String gender;
    private int age;
    private int height;
    private int weight;
    private double activity;
    private double recommendedCalories;

    public static Calculator getInstance() {
        return recommendation;
    }

    public Calculator() { }

    /**
     * Sets users gender.
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets users age in years.
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets users height in centimeters.
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Sets users weight in kilograms.
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Sets users activity level.
     * @param activity
     */
    public void setActivity(double activity) {
        this.activity = activity;
    }

    /**
     * Sets all characteristics at once.
     * @param gender
     * @param age
     * @param height
     * @param weight
     * @param activity
     */
    public void setAll(String gender, int age, int height, int weight, double activity) {
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.activity = activity;
    }

    /**
     * Sets recommended calorie intake.
     * @param recommendedCalories
     */
    public void setRecommendedCalories(int recommendedCalories) {
        this.recommendedCalories = recommendedCalories;
    }

    /**
     * Calculates recommended calorie intake based on given information.
     * @return
     */
    public void calculate() {
        if(this.gender == "male") {
            this.recommendedCalories = (double) (66 + (13.7 * this.weight) + (5 * this.height) - (6.8
                    * this.age) * this.activity);
        }else if(this.gender == "female") {
            this.recommendedCalories = (double) (665 + (9.6 * this.weight) + (1.8 * this.height) - (4.7
                    * this.age) * this.activity);
        }else {
            this.recommendedCalories = 0;
        }
    }

    public String toString() {
        return this.age + " " + this.height + " " + this.weight + " " + this.activity;
    }

    /**
     * Returns recommended calorie intake.
     * @return
     */
    public int getRecommendation() {
        return (int) this.recommendedCalories;
    }
}
