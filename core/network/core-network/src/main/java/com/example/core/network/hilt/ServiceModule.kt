package com.example.core.network.hilt

import com.example.core.network.ListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providesOkhttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(
            HttpLoggingInterceptor().apply {
                // a condition can be put here to only log only debug builds
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .writeTimeout(10000L, TimeUnit.MILLISECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit
    }

    @Provides
    @Singleton
    fun providesServiceRetrofit(retrofit: Retrofit): ListService {
        return retrofit.create(ListService::class.java)
    }
}

// We can have this field in a class that lives in debug folder so we can have urls for debug/release
private const val SERVICE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
