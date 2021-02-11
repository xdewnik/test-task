package com.coolya.testapp.ui.fragment.course.crypto.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.coolya.testapp.core.response.Result
import com.coolya.testapp.data.dto.CryptoCourse
import com.coolya.testapp.ui.fragment.course.crypto.repo.CryptoRepository
import kotlinx.coroutines.Dispatchers

class CryptoViewModel(app:Application, private val repo: CryptoRepository): AndroidViewModel(app){

    val cryptoCourse: LiveData<Result<List<CryptoCourse>>> = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        emit(repo.getCryptoCourse())
    }

}