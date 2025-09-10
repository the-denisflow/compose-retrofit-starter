package com.example.kotlin_app.data.remote

import com.example.kotlin_app.data.dto.CoinDto
import retrofit2.http.GET

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>
}