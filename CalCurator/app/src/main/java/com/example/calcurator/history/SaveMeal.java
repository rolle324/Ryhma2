package com.example.calcurator.history;

public class SaveMeal {

    /**
     * Checks if there is a day object with matching date. If not, creates a new one.
     * @param date
     * @param meal
     * @param calories
     */
    public void saveMeal(String date, String meal, int calories) {
        BookOfDays allDays = BookOfDays.getInstance();
        boolean duplicate = false;

        for (int i = 0; i < allDays.getAllDays().size(); i++) {
            if (allDays.getDay(i).getDate().equals(date)) {
                allDays.getDay(i).addMeal(meal, calories);
                duplicate = true;
            }
        }

        if (duplicate == false) {
            Day day = new Day(date, meal, calories);
            allDays.addDay(day);
        }
    }
}
