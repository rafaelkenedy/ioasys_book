package com.rafael.ioasys_book.data_remote.datasource

import com.rafael.ioasys_book.data.datasource.remote.BooksRemoteDatasource
import com.rafael.ioasys_book.data_remote.mappers.toDomain
import com.rafael.ioasys_book.data_remote.service.BookService
import com.rafael.ioasys_book.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRemoteDatasourceImpl(
    private val bookService: BookService
) : BooksRemoteDatasource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {
        val response = bookService.getBooks("Bearer $accessToken", 1)
        if (response.isSuccessful) {
            response.body()?.data?.let { bookList ->
                query?.let {
                    emit(bookList.filter { book ->
                        book.title?.trim()?.contains(it, ignoreCase = true) ?: false
                    }.toDomain())
                } ?: run {
                    emit(bookList.toDomain())
                }
            }
        }
    }
}