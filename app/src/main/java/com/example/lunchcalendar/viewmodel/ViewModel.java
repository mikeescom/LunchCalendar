package com.example.lunchcalendar.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.lunchcalendar.model.LunchWeek;
import com.example.lunchcalendar.model.Repository;

import java.util.List;
import java.util.Map;

public class ViewModel extends AndroidViewModel {
    private Repository repository;
    private MutableLiveData<Map<Integer, LunchWeek>> mutableLiveData = new MutableLiveData<>();

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public MutableLiveData<Map<Integer, LunchWeek>> getLunchWeeksList() {
        mutableLiveData.postValue(repository.getLunchWeekList());
        return mutableLiveData;
    }
}
