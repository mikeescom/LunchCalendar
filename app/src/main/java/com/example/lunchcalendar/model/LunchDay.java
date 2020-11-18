package com.example.lunchcalendar.model;

import java.util.Date;

public class LunchDay {
    private WeekDay weekDay;
    private String menu;

    public LunchDay(WeekDay weekDay, String menu) {
        this.weekDay = weekDay;
        this.menu = menu;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public String getMenu() {
        return menu;
    }
}
