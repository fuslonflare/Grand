package com.example.phuwarin.grand.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Phuwarin on 2/15/2017.
 */
public class HttpManager {
    private static HttpManager ourInstance = new HttpManager();
    private ApiService service;

    public static HttpManager getInstance() {
        return ourInstance;
    }

    private HttpManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fusionflare.esy.es/firebase_notification/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
    }

    public ApiService getService() {
        return service;
    }
}
