package com.rafael.ioasys_book.di

import com.rafael.ioasys_book.domain.usecase.LoginUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { LoginUseCase(get()) }

}