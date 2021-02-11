package com.coolya.testapp.ui.fragment.course.privat.di

import com.coolya.testapp.data.PrivatDataSource
import com.coolya.testapp.data.RemotePrivatDataSource
import com.coolya.testapp.ui.fragment.course.privat.repo.PrivatRepository
import com.coolya.testapp.ui.fragment.course.privat.vm.PrivatViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PrivatModule = module {
    factory<PrivatDataSource> { RemotePrivatDataSource(get())}
    factory { PrivatRepository(get()) }
    viewModel { PrivatViewModel(get(), get()) }
}