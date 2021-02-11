package com.coolya.testapp

import android.app.Application
import com.coolya.testapp.network.NetworkModule
import com.coolya.testapp.ui.fragment.course.crypto.di.CryptoModule
import com.coolya.testapp.ui.fragment.course.privat.di.PrivatModule
import com.coolya.testapp.ui.main.di.MainActivityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(
                NetworkModule,
                PrivatModule,
                CryptoModule,
                MainActivityModule
            ))
        }
        Timber.plant(Timber.DebugTree())
    }
}