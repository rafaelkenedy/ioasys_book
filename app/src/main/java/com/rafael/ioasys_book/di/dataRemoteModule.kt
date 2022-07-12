package com.rafael.ioasys_book.di

import com.rafael.ioasys_book.data.datasource.BooksDatasource
import com.rafael.ioasys_book.data.datasource.LoginDatasource
import com.rafael.ioasys_book.data_remote.datasource.BooksDatasourceImpl
import com.rafael.ioasys_book.data_remote.datasource.LoginDatasourceImpl
import com.rafael.ioasys_book.data_remote.service.AuthService
import com.rafael.ioasys_book.data_remote.utils.ApiConstants
import com.rafael.ioasys_book.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {

    single<AuthService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerOkHttpClient() }

    single<BooksDatasource> {
        BooksDatasourceImpl()
    }

    single<LoginDatasource> {
        LoginDatasourceImpl(get())
    }
}