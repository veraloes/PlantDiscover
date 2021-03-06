package com.example.plantdiscover.model


import com.google.gson.annotations.SerializedName

data class Data(
//    @SerializedName("common_name")
    val commonName: String,

//    @SerializedName("family_common_name")
    val familyCommonName: String,

//    @SerializedName("image_url")
    val imageUrl: String
)