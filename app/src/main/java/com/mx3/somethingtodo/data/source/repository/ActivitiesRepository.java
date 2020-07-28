package com.mx3.somethingtodo.data.source.repository;

import com.mx3.somethingtodo.webservice.ActivityApiInterface;
import com.mx3.somethingtodo.webservice.builder.RetrofitServiceBuilder;

public class ActivitiesRepository {

    private static final String LOG_TAG = ActivitiesRepository.class.getSimpleName();
    private static final Object LOCK = new Object();

    private static ActivitiesRepository sInstance;

    private ActivityApiInterface mActivityApiInterface;

    private ActivitiesRepository() {
        mActivityApiInterface = RetrofitServiceBuilder.buildService(ActivityApiInterface.class);
    }

    public static synchronized ActivitiesRepository getInstance() {
        synchronized (LOCK) {
            if (sInstance == null) {
                sInstance = new ActivitiesRepository();
            }
            return sInstance;
        }
    }


//    public Observable<List<Field>> getAllFields() {
//        return Observable.create(observer -> {
//            mFieldApiService.getAllFields().enqueue(new Callback<List<Field>>() {
//                @Override
//                public void onResponse(Call<List<Field>> call, Response<List<Field>> response) {
//                    if (response.isSuccessful()) {
//                        observer.onNext(response.body());
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<List<Field>> call, Throwable t) {
//                    observer.onError(t);
//                }
//            });
//            return Subscriptions.empty();
//        });
//    }
}
