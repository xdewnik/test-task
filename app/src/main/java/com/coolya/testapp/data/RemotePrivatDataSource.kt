package com.coolya.testapp.data

import com.coolya.testapp.data.dto.PrivatCourse
import com.coolya.testapp.network.PrivatApi


interface PrivatDataSource {
    suspend fun getCourseList(): List<PrivatCourse>
}


class RemotePrivatDataSource(private val privatApi: PrivatApi): PrivatDataSource {
    override suspend fun getCourseList(): List<PrivatCourse> = privatApi.getPrivatCourse()
}