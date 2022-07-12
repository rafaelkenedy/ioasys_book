package com.rafael.ioasys_book.data.datasource

import com.rafael.ioasys_book.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksDatasource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}