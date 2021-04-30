package com.example.calcurator.history;

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

    //Metodit
    /**
     * Add a day to the list of days
     * @param day
     */
    public void addDay(Day day){
        this.allDays.add(day);
    }

    /**
     * Get the complete list of days
     * @return
     */
    public List<Day> getAllDays() {
        return this.allDays;
    }

    /**
     * Get a specific day from the list of days
     * @param indexOfDay
     * @return
     */
    public Day getDay(int indexOfDay){
        return this.allDays.get(indexOfDay);
    }
}
