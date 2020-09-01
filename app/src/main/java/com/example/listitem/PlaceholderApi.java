package com.example.listitem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceholderApi {

    @GET("users")
    Call<List<Users>> getUsers();
}
