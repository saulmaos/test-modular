package com.example.core.network.hilt

import com.example.core.network.ServiceApiImpl
import com.example.core.network.api.ServiceApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceApiModule {
    @Binds
    abstract fun bindsServiceApi(serviceApi: ServiceApiImpl): ServiceApi
}
