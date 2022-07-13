package com.rafael.ioasys_book.di

import com.rafael.ioasys_book.data.datasource.remote.BooksRemoteDatasource
import com.rafael.ioasys_book.data.datasource.remote.LoginRemoteDatasource
import com.rafael.ioasys_book.data_remote.datasource.BooksRemoteDatasourceImpl
import com.rafael.ioasys_book.data_remote.datasource.LoginRemoteDatasourceImpl
import com.rafael.ioasys_book.data_remote.service.AuthService
import com.rafael.ioasys_book.data_remote.service.BookService
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

    single<BookService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerOkHttpClient() }

    single<BooksRemoteDatasource> {
        BooksRemoteDatasourceImpl(get())
    }

    single<LoginRemoteDatasource> {
        LoginRemoteDatasourceImpl(get())
    }
}