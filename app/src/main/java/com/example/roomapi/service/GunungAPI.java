package com.example.roomapi.service;

import com.example.roomapi.model.GunungApi;
import com.example.roomapi.model.GunungApiItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GunungAPI {
    String URL_BASE = "https://indonesia-public-static-api.vercel.app/";//Link API

    @GET("api/volcanoes")//Method mengambil data
    Call<List<GunungApiItem>> getGunung();
}
