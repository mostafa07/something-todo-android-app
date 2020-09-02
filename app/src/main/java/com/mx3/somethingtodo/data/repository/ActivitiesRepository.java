package com.mx3.somethingtodo.data.repository;

import com.mx3.somethingtodo.data.model.Activity;
import com.mx3.somethingtodo.webservice.ActivityApiWebService;
import com.mx3.somethingtodo.webservice.builder.RetrofitServiceBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.subscriptions.Subscriptions;

public class ActivitiesRepository {

    private static final String LOG_TAG = ActivitiesRepository.class.getSimpleName();

    private static ActivitiesRepository sInstance;

    private ActivityApiWebService mActivityApiWebService;

    // Constructor

    private ActivitiesRepository() {
        mActivityApiWebService = RetrofitServiceBuilder.buildService(ActivityApiWebService.class);
    }

    public static synchronized ActivitiesRepository getInstance() {
        synchronized (ActivitiesRepository.class) {
            if (sInstance == null) {
                sInstance = new ActivitiesRepository();
            }
            return sInstance;
        }
    }


    public Observable<Activity> retrieveRandomActivity(final Map<String, String> queryParams) {
        return Observable.create(observer -> {
            mActivityApiWebService.retrieveRandomActivity(queryParams).enqueue(new Callback<Activity>() {
                @Override
                public void onResponse(@NotNull Call<Activity> call, @NotNull Response<Activity> response) {
                    if (response.isSuccessful()) {
                        observer.onNext(response.body());
                    }
                }

                @Override
                public void onFailure(@NotNull Call<Activity> call, @NotNull Throwable t) {
                    observer.onError(t);
                }
            });

            return Subscriptions.empty();
        });
    }
}
