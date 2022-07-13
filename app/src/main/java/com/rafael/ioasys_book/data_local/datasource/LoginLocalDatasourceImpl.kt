package com.rafael.ioasys_book.data_local.datasource

import com.rafael.ioasys_book.data.datasource.local.LoginLocalDatasource
import com.rafael.ioasys_book.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import com.rafael.ioasys_book.data_local.utils.SharedPreferencesHelper

class LoginLocalDatasourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): LoginLocalDatasource {
    override fun saveAccessToken(acessToken: String) = sharedPreferencesHelper.saveString(
        key = ACCESS_TOKEN_KEY,
        value = acessToken
    )
}