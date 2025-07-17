package com.example.core.network.api

import com.google.gson.annotations.SerializedName

data class TerrainsResponse(
    @SerializedName("price")
    val price: Double,
    @SerializedName("id")
    val id: Long,
    @SerializedName("type")
    val type: String,
    @SerializedName("img_src")
    val imageUrl: String
)
