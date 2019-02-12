package com.example.challange3.infrastructure.service;

import com.example.challange3.models.FeedItemModel;
import com.example.challange3.models.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("/challenge")
    Call<UserModel> getUserAccountInfo();//observe,valid fragment,add-show hide fragment
}