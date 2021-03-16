package com.example.plantdiscover.model


import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("data")
    val data: List<DataValue>? = null

    data class DataValue(
        @SerializedName("author")
        val author: String,
        @SerializedName("bibliography")
        val bibliography: String,
        @SerializedName("common_name")
        val commonName: String,
        @SerializedName("family")
        val family: String,
        @SerializedName("family_common_name")
        val familyCommonName: String,
        @SerializedName("genus")
        val genus: String,
        @SerializedName("genus_id")
        val genusId: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image_url")
        val imageUrl: String,
        @SerializedName("links")
        val links: Links,
        @SerializedName("rank")
        val rank: String,
        @SerializedName("scientific_name")
        val scientificName: String,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("synonyms")
        val synonyms: List<String>,
        @SerializedName("year")
        val year: Int
    )
}

