package com.rafael.ioasys_book.data.datasource.remote

import com.rafael.ioasys_book.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDatasource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}