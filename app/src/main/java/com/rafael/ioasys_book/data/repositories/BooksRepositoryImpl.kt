package com.rafael.ioasys_book.data.repositories

import com.rafael.ioasys_book.data.datasource.BooksDatasource
import com.rafael.ioasys_book.domain.model.Book
import com.rafael.ioasys_book.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val booksDatasource: BooksDatasource
) : BooksRepository {
    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        booksDatasource.getBooks(accessToken, query)

}