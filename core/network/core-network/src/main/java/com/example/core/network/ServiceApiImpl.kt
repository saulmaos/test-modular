package com.example.core.network

import com.example.core.network.api.TerrainsResponse
import com.example.core.network.api.ServiceApi
import javax.inject.Inject

class ServiceApiImpl @Inject constructor(private val service: ListService): ServiceApi {
    override suspend fun getTerrains(): List<TerrainsResponse> {
        return service.getList()
    }
}
