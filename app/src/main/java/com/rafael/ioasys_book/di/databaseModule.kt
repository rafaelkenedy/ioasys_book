package com.rafael.ioasys_book.di

import androidx.room.Room
import com.rafael.ioasys_book.data_local.database.BookDatabase
import com.rafael.ioasys_book.data_local.utils.LocalConstants.BOOK_DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            BookDatabase::class.java,
            BOOK_DATABASE_NAME
        ).build()
    }

    single { get<BookDatabase>().bookDao() }
}