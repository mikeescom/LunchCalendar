package com.example.lunchcalendar.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.lunchcalendar.R;
import com.example.lunchcalendar.model.LunchWeek;
import com.example.lunchcalendar.viewmodel.ViewModel;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ViewModel viewModel;
    private CalendarView calendarView;
    private TextView descriptionTv;
    private TextView dateTv;
    private Calendar calendar = Calendar.getInstance(Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getLunchWeeksList().observe(this, this::updateUI);
    }

    private void initView() {
        calendarView = findViewById(R.id.calendar_view);
        dateTv = findViewById(R.id.date);
        descriptionTv = findViewById(R.id.description);
    }

    private void updateUI(Map<Integer, LunchWeek> lunchWeekMap) {
        Date date = new Date(calendarView.getDate());
        int day = date.getDay();
        dateTv.setText(date.toString());
        descriptionTv.setText(getMenu(day, lunchWeekMap.get(calendar.get(Calendar.WEEK_OF_YEAR))));

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            descriptionTv.setText("");
            calendar.set(year, month, dayOfMonth);
            int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
            LunchWeek lunchWeek = lunchWeekMap.get(weekOfYear);

            if (lunchWeek == null) {
                return;
            }

            dateTv.setText(calendar.getTime().toString());
            descriptionTv.setText(getMenu(calendar.get(Calendar.DAY_OF_WEEK)-1, lunchWeek));
        });
    }

    private String getMenu(int weekDay, LunchWeek lunchWeek) {
        String text = "";
        switch (weekDay) {
            case 1: text = lunchWeek.getMonday().getMenu(); break;
            case 2: text = lunchWeek.getTuesday().getMenu(); break;
            case 3: text = lunchWeek.getWednesday().getMenu(); break;
            case 4: text = lunchWeek.getThursday().getMenu(); break;
            case 5: text = lunchWeek.getFriday().getMenu(); break;
            default: text = "No lunch on weekends!";
        }
        return text;
    }
}