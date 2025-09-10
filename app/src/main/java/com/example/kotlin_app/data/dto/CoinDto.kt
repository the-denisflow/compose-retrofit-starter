package com.example.kotlin_app.data.dto

import com.example.kotlin_app.domain.model.Coin

data class CoinDto(
    var id: String,
    var is_active: Boolean,
    var is_new: Boolean,
    var name: String,
    var rank: Int,
    var symbol: String,
    var type: String
)

fun CoinDto.toCoin(): Coin = Coin(
    id = id,
    name = name,
    rank = rank,
    symbol = symbol
)