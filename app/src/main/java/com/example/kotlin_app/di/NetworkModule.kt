package com.example.kotlin_app.di

import com.example.kotlin_app.data.remote.YahooApi
import com.example.kotlin_app.data.repository.GetStockItemRepositoryImpl
import com.example.kotlin_app.domain.repository.GetStockItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideYahooApi(): YahooApi {
        return Retrofit.Builder()
            .baseUrl("https://query1.finance.yahoo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(YahooApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGetStockItemRepository(yahooApi: YahooApi): GetStockItemRepository {
        return GetStockItemRepositoryImpl(yahooApi)
    }

}