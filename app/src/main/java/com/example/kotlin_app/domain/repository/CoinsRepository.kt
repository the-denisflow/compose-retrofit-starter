package com.example.kotlin_app.domain.repository

import com.example.kotlin_app.data.dto.CoinDto

interface CoinsRepository {
    suspend fun getCoins(): List<CoinDto>
}