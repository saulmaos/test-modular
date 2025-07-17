package com.example.core.network

import com.example.core.network.api.TerrainsResponse
import retrofit2.http.GET

interface ListService {

    @GET("/realestate")
    suspend fun getList(): List<TerrainsResponse>
}
