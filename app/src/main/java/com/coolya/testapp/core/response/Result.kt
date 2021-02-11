package com.coolya.testapp.core.response

sealed class Result<T> {

    data class Success<T>(val data: T) : Result<T>()

    data class Failure<T>(val throwable: Throwable) : Result<T>()

    class Loading<T>: Result<T>()

}