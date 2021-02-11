package com.coolya.testapp.ui.fragment.course.crypto.di

import com.coolya.testapp.data.CryptoDataSource
import com.coolya.testapp.data.RemoteCryptoDataSource
import com.coolya.testapp.ui.fragment.course.crypto.repo.CryptoRepository
import com.coolya.testapp.ui.fragment.course.crypto.vm.CryptoViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val CryptoModule = module {
    factory<CryptoDataSource> { RemoteCryptoDataSource(get()) }
    factory { CryptoRepository(get()) }
    viewModel { CryptoViewModel(get(), get()) }
}