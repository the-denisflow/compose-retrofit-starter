package com.example.kotlin_app.data.repository

import com.example.kotlin_app.data.dto.YahooResultDto
import com.example.kotlin_app.data.remote.YahooApi
import com.example.kotlin_app.domain.repository.GetStockItemRepository
import javax.inject.Inject

class GetStockItemRepositoryImpl @Inject constructor(private val yahooApi: YahooApi) : GetStockItemRepository {
    override suspend fun getStockItem(symbol: String): YahooResultDto {
        return yahooApi.getStockData(symbol)
    }

}