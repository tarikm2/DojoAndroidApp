package com.example.tarikmerzouk.tylersuserapp.services;

import com.example.tarikmerzouk.tylersuserapp.models.UserListModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by tarikmerzouk on 10/7/17.
 */

public interface GetUsersService {
    @GET("users")
    Call<UserListModel> getUsers();

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            // Add the logging interceptor
            .addInterceptor(new HttpLoggingInterceptor().setLevel((HttpLoggingInterceptor.Level.BODY)))
            .followRedirects(false);

    GetUsersService mUserListService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.157:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(GetUsersService.class);
}