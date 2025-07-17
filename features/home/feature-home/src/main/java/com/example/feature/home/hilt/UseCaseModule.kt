package com.example.feature.home.hilt

import com.example.feature.home.domain.GetTerrainsUseCase
import com.example.feature.home.domain.GetTerrainsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
abstract class UseCaseModule {

    @ViewModelScoped
    @Binds
    abstract fun bindsGetTerrainsUseCase(getTerrainsUseCaseImpl: GetTerrainsUseCaseImpl): GetTerrainsUseCase
}
