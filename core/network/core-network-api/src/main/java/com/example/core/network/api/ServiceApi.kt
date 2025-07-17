package com.example.core.network.api

interface ServiceApi {
    suspend fun getTerrains(): List<TerrainsResponse>
}
