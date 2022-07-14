package com.rafael.ioasys_book.data.repositories

import com.rafael.ioasys_book.data.datasource.local.BooksLocalDataSource
import com.rafael.ioasys_book.data.datasource.remote.BooksRemoteDatasource
import com.rafael.ioasys_book.domain.model.Book
import com.rafael.ioasys_book.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRepositoryImpl(
    private val booksRemoteDatasource: BooksRemoteDatasource,
    private val booksLocalDataSource: BooksLocalDataSource
) : BooksRepository {
    override fun getBooks(query: String?): Flow<List<Book>> = flow {
        booksLocalDataSource.getAcessToken().collect { accessToken ->
            booksRemoteDatasource.getBooks(accessToken, query).collect { bookList ->
                emit(bookList)
            }
        }
    }

}