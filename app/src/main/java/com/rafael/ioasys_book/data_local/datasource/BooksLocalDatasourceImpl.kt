package com.rafael.ioasys_book.data_local.datasource

import com.rafael.ioasys_book.data.datasource.local.BooksLocalDataSource
import com.rafael.ioasys_book.data_local.database.BookDao
import com.rafael.ioasys_book.data_local.mappers.toDao
import com.rafael.ioasys_book.data_local.mappers.toDomain
import com.rafael.ioasys_book.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import com.rafael.ioasys_book.data_local.utils.SharedPreferencesHelper
import com.rafael.ioasys_book.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksLocalDatasourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val bookDao: BookDao

) : BooksLocalDataSource {
    override fun getAcessToken(): Flow<String> = flow {
        emit(sharedPreferencesHelper.getString(ACCESS_TOKEN_KEY))
    }

    override fun saveBooks(bookList: List<Book>) = bookDao.addBooks(
        bookList = bookList.map { it.toDao() }
    )

    override fun getBooks(query: String?): Flow<List<Book>> = flow {
        val bookList = bookDao.getBooks().map { it.toDomain() }

        query?.let {
            emit(bookList.filter { book ->
                book.title.trim().contains(it, ignoreCase = true)
            })
        } ?: run {
            emit(bookList)
        }

    }
}