package com.example.plantdiscover.model


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("genus")
    val genus: String,
    @SerializedName("plant")
    val plant: String,
    @SerializedName("self")
    val self: String
)