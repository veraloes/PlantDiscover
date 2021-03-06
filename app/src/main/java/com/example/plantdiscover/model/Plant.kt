package com.example.plantdiscover.model


import com.google.gson.annotations.SerializedName

data class Plant(
    @SerializedName("data")
    val `data`: List<DataValue>,
    @SerializedName("links")
    val links: LinksX,
    @SerializedName("meta")
    val meta: Meta
)