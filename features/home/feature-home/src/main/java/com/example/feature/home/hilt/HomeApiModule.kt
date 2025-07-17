package com.example.feature.home.hilt

import com.example.feature.home.api.HomeApi
import com.example.feature.home.api.HomeApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeApiModule {
    @Binds
    abstract fun bindsServiceApi(homeApiImpl: HomeApiImpl): HomeApi
}
