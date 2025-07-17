package com.example.feature.home.domain

import com.example.feature.home.R
import com.example.feature.home.models.Terrain
import com.example.feature.home.repository.TerrainsRepository
import com.example.feature.home.ui.HomeUIState
import com.example.feature.home.util.toTerrains
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetTerrainsUseCase {
    suspend operator fun invoke(): HomeUIState
}

class GetTerrainsUseCaseImpl @Inject constructor(
    private val repository: TerrainsRepository,
    private val dispatcher: CoroutineDispatcher
): GetTerrainsUseCase {
    override suspend fun invoke(): HomeUIState {
        return withContext(dispatcher) {
            return@withContext repository.getTerrains().fold(
                onSuccess = { terrainsResponse ->
                    val terrains: List<Terrain> = terrainsResponse.toTerrains()
                    HomeUIState.Success(terrains)
                },
                onFailure = {
                    //it.printStackTrace() This must be handled in a way it does not log when using the prod version
                    HomeUIState.Error(R.string.error)
                }
            )
        }
    }
}
