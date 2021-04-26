package com.example.calcurator;

import java.util.ArrayList;
import java.util.List;

public class BookOfCals {

private static final BookOfCals bookOfCals = new BookOfCals();
/**
 * Gets reference to singleton data
 */

public static BookOfCals getInstance() { return bookOfCals;}

private List<History> allHistory;

//Rakentaja

    private BookOfCals(){
        allHistory = new ArrayList<>();

        allHistory.add(new History("Nokkosia", 543));
    }

    //metodit
    public void lisaaRuoka(History history){
        this.allHistory.add(history);
    }

    public List<History> getAllHistory() {
        return this.allHistory;
    }

public History getHistory(int indexOfHistory){
        return this.allHistory.get(indexOfHistory);
}





}
