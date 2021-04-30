package com.example.calcurator;

import java.util.ArrayList;
import java.util.List;

public class BookOfDays {

private static final BookOfDays BookOfDays = new BookOfDays();
/**
 * Gets reference to singleton data
 */

public static BookOfDays getInstance() { return BookOfDays;}

private List<Day> allDays;

//Rakentaja

    private BookOfDays(){
        allDays = new ArrayList<>();

        allDays.add(new Day("26/04/2021", "Nokkosia", 5000));
    }

    //metodit
    public void addDay(Day day){
        this.allDays.add(day);
    }

    public List<Day> getAllDays() {
        return this.allDays;
    }

public Day getDay(int indexOfDay){
        return this.allDays.get(indexOfDay);
}





}
