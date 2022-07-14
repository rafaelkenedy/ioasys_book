package com.rafael.ioasys_book.di

import com.rafael.ioasys_book.data.datasource.local.BooksLocalDataSource
import com.rafael.ioasys_book.data.datasource.local.LoginLocalDatasource
import com.rafael.ioasys_book.data_local.datasource.BooksLocalDatasourceImpl
import com.rafael.ioasys_book.data_local.datasource.LoginLocalDatasourceImpl
import com.rafael.ioasys_book.data_local.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {
    single { SharedPreferencesHelper(androidContext()) }
    single<LoginLocalDatasource> { LoginLocalDatasourceImpl(get()) }
    single<BooksLocalDataSource> { BooksLocalDatasourceImpl(get()) }
}