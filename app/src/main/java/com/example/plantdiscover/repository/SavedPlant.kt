package com.example.plantdiscover.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_plant_table")

data class SavedPlant(
    @PrimaryKey(autoGenerate = true)
    var plantId: Long = 0L,

    @ColumnInfo(name = "plant_common_name")
    val plantCommonName: String,

    @ColumnInfo(name = "plant_img_url")
    val plantImgUrl: String
)