package com.example.plantdiscover

import com.example.plantdiscover.model.Data
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("/api/v1/plants?token=" + BuildConfig.YOUR_TREFLE_TOKEN)

    fun filterOnASingleValue(): Call<List<Data>>
}