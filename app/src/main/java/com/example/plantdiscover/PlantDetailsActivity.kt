package com.example.plantdiscover

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantdiscover.model.Data
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlantDetailsActivity : AppCompatActivity() {

    private var imageView: ImageView = findViewById(R.id.detail_image)
    private var commonName:TextView=findViewById(R.id.detail_common_name)
    private var family:TextView=findViewById(R.id.detail_family)
    private var familyCommonName:TextView=findViewById(R.id.detail_family_common_name)
    private var genus:TextView=findViewById(R.id.detail_genus)
    private var rank:TextView=findViewById(R.id.detail_rank)
    private var scientificName:TextView=findViewById(R.id.detail_scientisic_name)
    private var synonyms:TextView=findViewById(R.id.detail_synonyms)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_details)


    }
}