package com.example.kotlin_app.presentation.viewmodel

import com.example.kotlin_app.common.Resource
import com.example.kotlin_app.domain.model.Coin

data class CoinsListState(
    val result: ApiResult = ApiResult.Loading,
    val coins: List<Coin> = emptyList(),
)

sealed class ApiResult {
    data object Loading : ApiResult()
    data object Success : ApiResult()
    data class Error(val message: String) : ApiResult()
}

fun CoinsListState.fromResource(result: Resource<List<Coin>>): CoinsListState =
    when (result){
        is Resource.Loading -> copy(result = ApiResult.Loading)
        is Resource.Success -> copy(result = ApiResult.Success, coins = result.data ?: emptyList())
        is Resource.Error -> copy(result = ApiResult.Error(result.message ?: "An unexpected error occured"))
    }
