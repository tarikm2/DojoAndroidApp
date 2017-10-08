package com.example.tarikmerzouk.tylersuserapp.services;

import com.example.tarikmerzouk.tylersuserapp.models.NewUserRequest;
import com.example.tarikmerzouk.tylersuserapp.models.NewUserResponse;
import com.example.tarikmerzouk.tylersuserapp.models.UserListModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by tarikmerzouk on 10/7/17.
 */

public interface NewUsersService {
    @POST("users")
    Call<NewUserResponse> newUsers(@Body NewUserRequest theRequest);

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            // Add the logging interceptor
            .addInterceptor(new HttpLoggingInterceptor().setLevel((HttpLoggingInterceptor.Level.BODY)))
            .followRedirects(false);

    NewUsersService mNewUserService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.157:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(NewUsersService.class);
}