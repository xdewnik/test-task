package com.coolya.testapp.ui.fragment.course.privat.repo

import com.coolya.testapp.core.response.Result
import com.coolya.testapp.data.PrivatDataSource
import com.coolya.testapp.data.dto.PrivatCourse

class PrivatRepository(private val privatDataSource: PrivatDataSource){


    suspend fun getPrivatCourse() = try {
        Result.Success(privatDataSource.getCourseList())
    }catch (e:Throwable) {
        Result.Failure<List<PrivatCourse>>(e)
    }
}