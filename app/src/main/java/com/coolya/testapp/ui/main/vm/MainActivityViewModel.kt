package com.coolya.testapp.ui.main.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.coolya.testapp.core.response.Result
import com.coolya.testapp.data.dto.CourseItem
import com.coolya.testapp.ui.main.repo.MainRepository
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel(app: Application, private val mainRepo: MainRepository) : AndroidViewModel(app) {


    private val _isViewPager: MutableLiveData<Boolean> = MutableLiveData(true)
    val isViewPager: LiveData<Boolean>
        get() = _isViewPager

    var combinedCourse: LiveData<Result<out List<CourseItem>>> =
        liveData(Dispatchers.IO) {
            emit(Result.Loading())
        emit(mainRepo.getCombinedList())  }


    fun toggleMode(){
        _isViewPager.postValue(!_isViewPager.value!!)
    }


}