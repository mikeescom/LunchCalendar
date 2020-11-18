package com.example.lunchcalendar.model;

import java.util.Date;

public class LunchWeek {
    private final LunchDay monday;
    private final LunchDay tuesday;
    private final LunchDay wednesday;
    private final LunchDay thursday;
    private final LunchDay friday;

    public LunchWeek(String monday, String tuesday, String wednesday, String thursday, String friday) {
        this.monday = new LunchDay(WeekDay.MONDAY, monday);
        this.tuesday = new LunchDay(WeekDay.TUESDAY, tuesday);
        this.wednesday = new LunchDay(WeekDay.WEDNESDAY, wednesday);
        this.thursday = new LunchDay(WeekDay.THURSDAY, thursday);
        this.friday = new LunchDay(WeekDay.FRIDAY, friday);
    }

    public LunchDay getMonday() {
        return monday;
    }

    public LunchDay getTuesday() {
        return tuesday;
    }

    public LunchDay getWednesday() {
        return wednesday;
    }

    public LunchDay getThursday() {
        return thursday;
    }

    public LunchDay getFriday() {
        return friday;
    }
}
