package com.example.calcurator.history;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.example.calcurator.MainActivity;

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
    }

    //Metodit
    /**
     * Adds a day to the list of days
     * @param day
     */
    public void addDay(Day day){
        this.allDays.add(day);
    }

    /**
     * Gets the complete list of days
     * @return
     */
    public List<Day> getAllDays() {
        return this.allDays;
    }

    /**
     * Gets a specific day from the list of days
     * @param indexOfDay
     * @return
     */

    public Day getDay(int indexOfDay){
        return this.allDays.get(indexOfDay);
    }

    /**
     * Sets the list of days
     * @param list
     */
    public void setAllDays(List<Day> list) {
        this.allDays = list;
    }
}
