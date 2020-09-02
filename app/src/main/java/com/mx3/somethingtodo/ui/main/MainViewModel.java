package com.mx3.somethingtodo.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mx3.somethingtodo.R;
import com.mx3.somethingtodo.data.model.Activity;
import com.mx3.somethingtodo.data.model.Message;
import com.mx3.somethingtodo.data.repository.ActivitiesRepository;

import java.util.HashMap;

public class MainViewModel extends ViewModel {

    private static final String LOG_TAG = MainViewModel.class.getSimpleName();

    private ActivitiesRepository sActivitiesRepository;

    private MutableLiveData<Activity> mActivityMutableLiveData;
    private MutableLiveData<Boolean> mIsProgressDialogShownMutableLiveData;
    private MutableLiveData<Message> mErrorMessageMutableLiveData;

    // Constructor

    public MainViewModel() {
        sActivitiesRepository = ActivitiesRepository.getInstance();

        mActivityMutableLiveData = new MutableLiveData<>();
        mIsProgressDialogShownMutableLiveData = new MutableLiveData<>(false);
        mErrorMessageMutableLiveData = new MutableLiveData<>();

        // retrieve random activity for thr first time
        retrieveRandomActivity();
    }

    // Other methods

    public void retrieveRandomActivity() {
        mIsProgressDialogShownMutableLiveData.setValue(true);

        // TODO insert required params
        final HashMap<String, String> queryParams = new HashMap<>();
        sActivitiesRepository.retrieveRandomActivity(queryParams).subscribe(activity -> {
            mIsProgressDialogShownMutableLiveData.setValue(false);
            mActivityMutableLiveData.setValue(activity);
        }, throwable -> {
            mIsProgressDialogShownMutableLiveData.setValue(false);
            mErrorMessageMutableLiveData.setValue(new Message(R.string.error_message));
            throwable.printStackTrace();
        });
    }

    // Getters and setters

    public LiveData<Activity> getActivityLiveData() {
        return mActivityMutableLiveData;
    }

    public LiveData<Boolean> getIsProgressDialogShownLiveData() {
        return mIsProgressDialogShownMutableLiveData;
    }

    public LiveData<Message> getErrorMessageLiveData() {
        return mErrorMessageMutableLiveData;
    }
}
