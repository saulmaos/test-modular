package com.example.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature.home.domain.GetTerrainsUseCase
import com.example.feature.home.models.Terrain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTerrainsUseCase: GetTerrainsUseCase
): ViewModel() {

    val homeState = MutableStateFlow<HomeUIState>(HomeUIState.Idle)
    fun requestTerrains() {
        viewModelScope.launch {
            homeState.value = HomeUIState.Loading
            homeState.value = getTerrainsUseCase()
        }
    }
}

sealed interface HomeUIState {
    object Idle: HomeUIState
    object Loading: HomeUIState
    data class Success(val terrains: List<Terrain>): HomeUIState
    data class Error(val errorId: Int): HomeUIState
}
