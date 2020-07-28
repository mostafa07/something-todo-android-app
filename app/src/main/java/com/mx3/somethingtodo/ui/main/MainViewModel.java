package com.mx3.somethingtodo.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mx3.somethingtodo.data.source.remote.response.ActivityResponse;

public class MainViewModel extends ViewModel {

    private MutableLiveData<ActivityResponse> activityMutableLiveData;

    // Constructor

    public MainViewModel() {
        this.activityMutableLiveData = new MutableLiveData<>();
    }

    // Other methods



    // Getters and setters

    public LiveData<ActivityResponse> getActivityLiveData() {
        return activityMutableLiveData;
    }
}
