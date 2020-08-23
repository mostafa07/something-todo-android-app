package com.mx3.somethingtodo.webservice;

import com.mx3.somethingtodo.data.model.Activity;
import com.mx3.somethingtodo.util.ApiEndPoints;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ActivityApiWebService {

    @GET(ApiEndPoints.ACTIVITY_END_POINT)
    Call<Activity> retrieveRandomActivity(@QueryMap Map<String, String> queryParams);
}
