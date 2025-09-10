package com.example.kotlin_app.presentation.viewmodel

import com.example.kotlin_app.common.Resource
import com.example.kotlin_app.domain.model.StockItem

data class StockItemState(
    val message: String = "",
    val item: StockItem? = null,
    val isLoading: Boolean = false,
)

fun StockItemState.update(result: Resource<StockItem>) =
    when (result) {
        is Resource.Success -> copy(
            item = result.data
        )

        is Resource.Error -> copy(item = null, message = result.message ?: "Unknown error")
        is Resource.Loading -> copy(message = "Loading")
    }

