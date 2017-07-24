package com.example.phuwarin.grand.service;

import com.example.phuwarin.grand.model.MessageDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Phuwarin on 2/15/2017.
 */

public interface ApiService {
    @GET("report.php")
    Call<List<MessageDao>> pushNotification();
}
