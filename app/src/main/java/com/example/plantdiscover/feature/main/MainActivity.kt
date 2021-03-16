package com.example.plantdiscover.feature.main

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantdiscover.AdapterPlant
import com.example.plantdiscover.ApiService
import com.example.plantdiscover.R
import com.example.plantdiscover.model.Data
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeRetrofit()
        setupToolbar()
    }

    private fun initializeRetrofit() {
        val apiBaseUrl = "https://trefle.io/api/v1/"

        val retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(ApiService::class.java)
        api.fetchSpecies().enqueue(object : Callback<Data> {
//            api.searchPodcastByTerm("coconut").enqueue(object : Callback<Data> {


            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                Log.d("plant", "onResponse")
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("plant", "onFail")
            }
        })

    }

    private fun showData(plants: Data) {
        myFirstRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = plants.data?.let { AdapterPlant(it) }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        val searchMenuItem = menu.findItem(R.id.search_item)
        val searchView = searchMenuItem?.actionView as androidx.appcompat.widget.SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE)
                as SearchManager
        searchView.setSearchableInfo(
            searchManager.getSearchableInfo(componentName)
        )
        return true
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
    }
}