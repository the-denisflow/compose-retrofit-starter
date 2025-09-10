package com.example.kotlin_app.domain.repository

import com.example.kotlin_app.data.dto.YahooResultDto

interface GetStockItemRepository {
    suspend fun getStockItem(symbol: String): YahooResultDto
}