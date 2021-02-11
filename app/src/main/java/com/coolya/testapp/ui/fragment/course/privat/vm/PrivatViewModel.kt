package com.coolya.testapp.ui.fragment.course.privat.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.coolya.testapp.core.response.Result
import com.coolya.testapp.data.dto.PrivatCourse
import com.coolya.testapp.ui.fragment.course.privat.repo.PrivatRepository
import kotlinx.coroutines.Dispatchers

class PrivatViewModel(app: Application, private val repo: PrivatRepository): AndroidViewModel(app){

    val privatCourse: LiveData<Result<List<PrivatCourse>>> = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        emit(repo.getPrivatCourse())
    }

}