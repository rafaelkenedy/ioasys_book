package com.rafael.ioasys_book.domain.repositories

import com.rafael.ioasys_book.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}