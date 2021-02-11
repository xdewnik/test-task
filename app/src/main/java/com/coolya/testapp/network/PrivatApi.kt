package com.coolya.testapp.network

import com.coolya.testapp.data.dto.PrivatCourse
import retrofit2.http.GET
import retrofit2.http.Query

interface PrivatApi {

    @GET("pubinfo?json&exchange")
    suspend fun getPrivatCourse(@Query("coursid") courseId: Int = 5): List<PrivatCourse>
}