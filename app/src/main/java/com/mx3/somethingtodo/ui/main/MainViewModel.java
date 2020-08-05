package com.mx3.somethingtodo.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mx3.somethingtodo.data.model.Activity;
import com.mx3.somethingtodo.data.repository.ActivitiesRepository;

import java.util.HashMap;

public class MainViewModel extends ViewModel {

    private ActivitiesRepository sActivitiesRepository;
    private MutableLiveData<Activity> mActivityMutableLiveData;

    // Constructor

    public MainViewModel() {
        sActivitiesRepository = ActivitiesRepository.getInstance();
        mActivityMutableLiveData = new MutableLiveData<>();
    }

    // Other methods

    public void retrieveRandomActivity() {
        // TODO insert required params
        final HashMap<String, String> queryParams = new HashMap<>();

        sActivitiesRepository.retrieveRandomActivity(queryParams).subscribe(response -> {
            mActivityMutableLiveData.postValue(response);
        }, throwable -> {
            throwable.printStackTrace();
        });
    }

    // Getters and setters

    public LiveData<Activity> getActivityLiveData() {
        return mActivityMutableLiveData;
    }
}
