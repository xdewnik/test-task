package com.coolya.testapp.ui.main.di

import com.coolya.testapp.ui.main.repo.MainRepository
import com.coolya.testapp.ui.main.vm.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val MainActivityModule = module {
    factory { MainRepository(get(), get()) }
    viewModel { MainActivityViewModel(get(),get()) }
}