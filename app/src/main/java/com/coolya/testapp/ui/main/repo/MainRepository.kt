package com.coolya.testapp.ui.main.repo

import com.coolya.testapp.core.response.Result
import com.coolya.testapp.data.CryptoDataSource
import com.coolya.testapp.data.PrivatDataSource
import com.coolya.testapp.data.dto.CourseItem
import com.coolya.testapp.data.dto.Header
import java.util.*

class MainRepository(private val privateDataSource: PrivatDataSource, private val cryptoDataSource: CryptoDataSource) {


    suspend fun getCombinedList() = try{
        val combinedList = LinkedList<CourseItem>()
        var errorCount = 0
        try{
            val list =privateDataSource.getCourseList()
            combinedList.add(Header("Privat course"))
            combinedList.addAll(list)
        }catch (e:Throwable){
            errorCount += 1
        }
        try{
            val list = cryptoDataSource.getCourseList()
            combinedList.add(Header("Crypto course"))
            combinedList.addAll(list)
        }catch (e:Throwable){
            errorCount += 1
        }
        if(errorCount == 2){
            throw Throwable("Can't get courses")
        }
        Result.Success(combinedList)
    }catch (e:Throwable){
        Result.Failure<List<CourseItem>>(e)
    }




}