package com.example.kotlin_app.data.remote

import com.example.kotlin_app.data.dto.YahooResultDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface YahooApi {
    // example https://query1.finance.yahoo.com/v8/finance/chart/NVDA?range=1y&interval=1d
    @GET("v8/finance/chart/{symbol}")
    suspend fun getStockData(
        @Path("symbol") symbol: String,
        @Query("interval") interval: String = "1d",
        @Query("range") range: String = "1y",
        @Query("includePrePost") includePrePost: Boolean = false): YahooResultDto
}