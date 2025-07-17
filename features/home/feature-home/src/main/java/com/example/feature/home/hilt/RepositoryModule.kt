package com.example.feature.home.hilt

import com.example.feature.home.repository.TerrainsRepository
import com.example.feature.home.repository.TerrainsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsTerrainsRepository(terrainsRepositoryImpl: TerrainsRepositoryImpl): TerrainsRepository

}
