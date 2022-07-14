package com.rafael.ioasys_book.data.datasource.local

import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAcessToken(): Flow<String>
}