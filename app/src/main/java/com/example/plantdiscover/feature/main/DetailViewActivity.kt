package com.example.plantdiscover.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plantdiscover.AdapterPlant
import com.example.plantdiscover.R
import com.example.plantdiscover.model.Data
import kotlinx.android.synthetic.main.activity_main.*

class DetailViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plant_detail_item)
    }


}