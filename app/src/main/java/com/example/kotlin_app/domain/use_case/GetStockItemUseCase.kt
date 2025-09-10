package com.example.kotlin_app.domain.use_case

import android.util.Log
import com.example.kotlin_app.common.Constants
import com.example.kotlin_app.common.Resource
import com.example.kotlin_app.data.dto.toStockItem
import com.example.kotlin_app.domain.model.StockItem
import com.example.kotlin_app.domain.repository.GetStockItemRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetStockItemUseCase @Inject constructor(private val repository: GetStockItemRepository) {
    operator fun invoke(symbol: String): Flow<Resource<StockItem>> = flow {
        var lastPrice: Double? = null

        while (true) {
            try {
                if (lastPrice == null) {
                    emit(Resource.Loading())
                }
                val item = repository.getStockItem(symbol).toStockItem()
                if (lastPrice == null || lastPrice != item.regularMarketPrice) {
                    Log.d("GetStockItemUseCase", "getStockItem: ${item.regularMarketPrice}")
                    emit(Resource.Success(item))
                    lastPrice = item.regularMarketPrice
                }
            } catch (e: Exception) {
                emit(Resource.Error<StockItem>(e.localizedMessage ?: "Unknown error"))
            }
            delay(5000)
        }
    }

}