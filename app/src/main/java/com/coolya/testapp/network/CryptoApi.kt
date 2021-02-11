package com.coolya.testapp.network

import com.coolya.testapp.data.dto.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {

    @GET("assets")
    suspend fun getCryptoList(@Query("limit") limit: Int= 10): CryptoResponse
}