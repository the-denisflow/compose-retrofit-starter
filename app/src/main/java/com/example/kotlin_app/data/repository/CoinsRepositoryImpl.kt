package com.example.kotlin_app.data.repository

import com.example.kotlin_app.data.dto.CoinDto
import com.example.kotlin_app.data.remote.CoinPaprikaApi
import com.example.kotlin_app.domain.repository.CoinsRepository
import javax.inject.Inject

class CoinsRepositoryImpl@Inject constructor(private val coinPaprikaApi: CoinPaprikaApi) :
    CoinsRepository {
    override suspend fun getCoins(): List<CoinDto> = coinPaprikaApi.getCoins()
}