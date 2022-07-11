package com.rafael.ioasys_book.di

import com.rafael.ioasys_book.presentation.viewmodel.BookListViewModel
import com.rafael.ioasys_book.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PresentationModule = module {
    viewModel { LoginViewModel() }
    viewModel { BookListViewModel() }
}