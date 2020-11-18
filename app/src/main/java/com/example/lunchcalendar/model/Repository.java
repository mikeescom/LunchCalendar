package com.example.lunchcalendar.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Repository {
    private LunchWeek week1;
    private LunchWeek week2;
    private Map<Integer, LunchWeek> lunchWeekList = new HashMap<>();
    Calendar cal = Calendar.getInstance(Locale.US);
    int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);

    public Repository() {
        week1 = new LunchWeek("Chicken and waffles",
                "Tacos",
                "Curry",
                "Pizza",
                "Sushi");

        week2 = new LunchWeek("Breakfast for lunch",
                "Hamburgers",
                "Spaghetti",
                "Salmon",
                "Sandwiches");
        lunchWeekList.put(weekOfYear, week1);
        lunchWeekList.put(weekOfYear+1, week2);
    }

    public Map<Integer, LunchWeek> getLunchWeekList() {
        return lunchWeekList;
    }
}
