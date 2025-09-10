package com.example.kotlin_app.domain.use_case

import com.example.kotlin_app.common.Resource
import com.example.kotlin_app.common.safeApiCall
import com.example.kotlin_app.data.dto.toCoin
import com.example.kotlin_app.domain.model.Coin
import com.example.kotlin_app.domain.repository.CoinsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val coinsRepository: CoinsRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = safeApiCall {
        val result = coinsRepository.getCoins().map { it.toCoin() }
        result
    }
}
