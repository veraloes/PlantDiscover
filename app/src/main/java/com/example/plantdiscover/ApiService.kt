package com.example.plantdiscover

import com.example.plantdiscover.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiService {



    @GET ("comments?postId=1")

    //            + BuildConfig.YOUR_TREFLE_TOKEN)

    fun fetchAllUsers(): Call<List<User>>


}