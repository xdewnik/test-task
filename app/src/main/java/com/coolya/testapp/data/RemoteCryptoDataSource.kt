package com.coolya.testapp.data

import com.coolya.testapp.data.dto.CryptoCourse
import com.coolya.testapp.network.CryptoApi

interface CryptoDataSource {
    suspend fun getCourseList(): List<CryptoCourse>
}


class RemoteCryptoDataSource(private val cryptoApi: CryptoApi): CryptoDataSource {
    override suspend fun getCourseList(): List<CryptoCourse> = cryptoApi.getCryptoList().data


}