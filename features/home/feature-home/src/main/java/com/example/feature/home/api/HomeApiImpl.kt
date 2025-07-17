package com.example.feature.home.api

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.feature.home.ui.HomeScreen
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class HomeApiImpl @Inject constructor(): HomeApi {
    @Composable
    override fun launchHome(modifier: Modifier) {
        HomeScreen(modifier)
    }

    override fun la() {
        Log.d("api", "apieand")
    }
}

interface HomeApi2 {
    @Composable
    fun launchHome(modifier: Modifier)
}

class HomeApi2Impl @Inject constructor(): HomeApi2 {
    @Composable
    override fun launchHome(modifier: Modifier) {
        HomeScreen(modifier)
    }
}

@InstallIn(SingletonComponent::class)
@Module
abstract class HomeApi2Module {
    @Binds
    abstract fun bindsHomeApi2(homeApi2: HomeApi2Impl): HomeApi2
}
