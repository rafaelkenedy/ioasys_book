package com.rafael.ioasys_book.data_remote.datasource

import com.rafael.ioasys_book.data.datasource.BooksDatasource
import com.rafael.ioasys_book.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksDatasourceImpl : BooksDatasource {
    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {
        val books = Book.getMockListCount()

        query?.let {
            emit(books.filter { book ->
                book.name.trim().contains(query, true)
            })
        } ?: run {
            emit(books)
        }
    }
}