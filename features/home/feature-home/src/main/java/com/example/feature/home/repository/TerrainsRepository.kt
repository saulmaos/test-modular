package com.example.feature.home.repository

import com.example.core.network.api.TerrainsResponse
import com.example.core.network.api.ServiceApi
import javax.inject.Inject

interface TerrainsRepository {
    suspend fun getTerrains(): Result<List<TerrainsResponse>>
}

class TerrainsRepositoryImpl @Inject constructor(
    private val serviceApi: ServiceApi
): TerrainsRepository {
    override suspend fun getTerrains(): Result<List<TerrainsResponse>> {
        return runCatching {
            serviceApi.getTerrains()
        }
    }
}
