package com.example.feature.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.feature.home.R
import com.example.feature.home.models.Terrain

@Composable
internal fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        val uiState: HomeUIState by viewModel.homeState.collectAsStateWithLifecycle()
        when (uiState) {
            is HomeUIState.Error -> {
                ErrorStateScreen {
                    viewModel.requestTerrains()
                }
            }

            HomeUIState.Loading -> {
                LoadingStateScreen()
            }

            HomeUIState.Idle -> {
                IdleStateScreen {
                    viewModel.requestTerrains()
                }
            }

            is HomeUIState.Success -> {
                SuccessStateScreen((uiState as HomeUIState.Success).terrains)
            }
        }
    }
}

@Composable
private fun BoxScope.IdleStateScreen(onRequestTerrains: () -> Unit) {
    Button(
        onClick = {
            onRequestTerrains()
        },
        modifier = Modifier.align(Alignment.Center)
    ) {
        Text("Load terrains")
    }
}

@Composable
private fun ErrorStateScreen(onRequestTerrains: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("An error occurred. Please try again later.")
        Button(
            onClick = {
                onRequestTerrains()
            }
        ) {
            Text("Load terrains")
        }
    }
}

@Composable
private fun BoxScope.LoadingStateScreen() {
    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
}

@Composable
private fun SuccessStateScreen(terrains: List<Terrain>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(terrains) { terrain: Terrain ->
            ImageCard(terrain)
        }
    }
}

@Composable
private fun ImageCard(terrain: Terrain) {
    Card {
        Column {
            // it's possible with coil to display different states based on the current state of the load.
            // IE: a loader when it's loading, an error image when the image couldn't be fetched
            AsyncImage(
                model = terrain.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(terrain.price)
                Text(stringResource(R.string.terrain_type, terrain.type))
            }
        }
    }
}
