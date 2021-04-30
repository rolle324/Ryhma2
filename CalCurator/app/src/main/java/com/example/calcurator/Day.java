package com.example.calcurator;

import java.util.ArrayList;

public class Day {

    //INSTANSSIMUUTTUJAT
    private String meal;
    private int totalcalories;
    private String date;


    //RAKENTAJA
    public Day(String date, String meal, int totalcalories) {
        this.date = date;
        this.meal = meal;
        this.totalcalories = totalcalories;
    }

    //METODIT
public String getDate(){
        return this.date;
}

    public String getmeal() {
    return this.meal;
    }

    public int getcalories(){
        return this.totalcalories;
    }

    @Override
    public String toString() {
        return this.date;
    }
}


