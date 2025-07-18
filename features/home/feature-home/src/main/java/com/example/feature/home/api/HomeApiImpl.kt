package com.example.feature.home.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.feature.home.ui.HomeScreen
import javax.inject.Inject

class HomeApiImpl @Inject constructor(): HomeApi {
    @Composable
    override fun LaunchHome(modifier: Modifier) {
        HomeScreen(modifier)
    }
}
