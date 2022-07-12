package com.rafael.ioasys_book.di

import com.rafael.ioasys_book.presentation.viewmodel.BookListViewModel
import com.rafael.ioasys_book.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { BookListViewModel(get()) }
}