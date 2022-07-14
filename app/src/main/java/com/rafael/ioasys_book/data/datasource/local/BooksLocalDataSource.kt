package com.rafael.ioasys_book.data.datasource.local

import com.rafael.ioasys_book.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAcessToken(): Flow<String>
    fun saveBooks(bookList: List<Book>)
    fun getBooks(query: String?): Flow<List<Book>>
}