package com.rafael.ioasys_book.di

import com.rafael.ioasys_book.data.datasource.BooksDatasource
import com.rafael.ioasys_book.data.datasource.LoginDatasource
import com.rafael.ioasys_book.data_remote.datasource.BooksDatasourceImpl
import com.rafael.ioasys_book.data_remote.datasource.LoginDatasourceImpl
import org.koin.dsl.module

val dataRemoteModule = module {

    single<BooksDatasource> {
        BooksDatasourceImpl()
    }

    single<LoginDatasource> {
        LoginDatasourceImpl()
    }
}