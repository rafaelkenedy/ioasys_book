package com.rafael.ioasys_book.data_local.datasource

import com.rafael.ioasys_book.data.datasource.local.BooksLocalDataSource
import com.rafael.ioasys_book.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import com.rafael.ioasys_book.data_local.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksLocalDatasourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : BooksLocalDataSource {
    override fun getAcessToken(): Flow<String> = flow {
        emit(sharedPreferencesHelper.getString(ACCESS_TOKEN_KEY))
    }
}