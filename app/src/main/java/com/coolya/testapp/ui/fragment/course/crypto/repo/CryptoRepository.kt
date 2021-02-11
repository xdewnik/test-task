package com.coolya.testapp.ui.fragment.course.crypto.repo

import com.coolya.testapp.core.response.Result
import com.coolya.testapp.data.CryptoDataSource
import com.coolya.testapp.data.dto.CryptoCourse

class CryptoRepository (private val dataSource: CryptoDataSource){


    suspend fun getCryptoCourse() = try {
        Result.Success(dataSource.getCourseList())
    }catch (e:Throwable) {
        Result.Failure<List<CryptoCourse>>(e)
    }

}