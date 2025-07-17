package com.example.core.network.hilt

import com.example.core.network.ListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    //fun porividesOkhttpClient()


    @Provides
    @Singleton
    fun providesServiceRetrofit(): ListService {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ListService::class.java)
    }
}
