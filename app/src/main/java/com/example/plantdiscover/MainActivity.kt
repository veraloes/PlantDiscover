package com.example.plantdiscover

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.example.plantdiscover.model.Data
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val client = OkHttpClient.Builder().addInterceptor(logging).build()

        val apiBaseUrl = "https://trefle.io/api/v1/"

        val retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl).client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(ApiService::class.java)
        api.fetchSpecies().enqueue(object : Callback<Data> {

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                d("plant", "onResponse")
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                d("plant", "onFail")
            }
        })
    }

    private fun showData(plants: Data) {
        val myFirstRecyclerView = findViewById<RecyclerView>(R.id.myFirstRecyclerView)
        myFirstRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = plants.data?.let { AdapterPlant(it) }
        }
    }
}