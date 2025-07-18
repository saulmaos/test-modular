package com.example.test2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.feature.home.api.HomeApi
import com.example.test2.ui.theme.Test2Theme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeApi: HomeApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Here we can have a navigation which would handle all the routes
                    homeApi.LaunchHome(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
