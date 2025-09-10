package com.example.kotlin_app.di

import com.example.kotlin_app.common.Constants
import com.example.kotlin_app.data.remote.CoinPaprikaApi
import com.example.kotlin_app.data.repository.CoinsRepositoryImpl
import com.example.kotlin_app.domain.repository.CoinsRepository
import com.example.kotlin_app.domain.use_case.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi =
        Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideCoinsRepository(coinPaprikaApi: CoinPaprikaApi): CoinsRepository =
        CoinsRepositoryImpl(coinPaprikaApi)

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(coinsRepository: CoinsRepository): GetCoinsUseCase =
        GetCoinsUseCase(coinsRepository)
}