package com.example.plantdiscover

data class User (
    //    @SerializedName("common_name")
    var postId: Int = 0,
    var id: Int = 0,
    var name: String? =null,

    //    @SerializedName("family_common_name")
    var email: String? =null,
    var body: String? =null

)