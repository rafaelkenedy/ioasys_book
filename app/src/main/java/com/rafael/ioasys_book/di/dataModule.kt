package com.rafael.ioasys_book.di

import com.rafael.ioasys_book.data.repositories.BooksRepositoryImpl
import com.rafael.ioasys_book.data.repositories.LoginRepositoryImpl
import com.rafael.ioasys_book.domain.repositories.BooksRepository
import com.rafael.ioasys_book.domain.repositories.LoginRepository
import org.koin.dsl.module

val dataModule = module {

    single<BooksRepository> {
        BooksRepositoryImpl(get())
    }

    single<LoginRepository> {
        LoginRepositoryImpl(get())
    }
}