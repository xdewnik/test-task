package com.coolya.testapp.network

import com.coolya.testapp.BuildConfig.CRYPTO_URL
import com.coolya.testapp.BuildConfig.PRIVAT_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {


    factory { OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
    }

    single { Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(PRIVAT_URL)
        .client(get())
        .build()
        .create(PrivatApi::class.java)
    }

    single { Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(CRYPTO_URL)
        .client(get())
        .build()
        .create(CryptoApi::class.java)
    }
}