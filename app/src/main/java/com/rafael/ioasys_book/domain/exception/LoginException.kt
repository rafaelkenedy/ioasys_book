package com.rafael.ioasys_book.domain.exception

open class LoginException : Exception()

class InvalidEmailException: LoginException()
class InvalidPasswordException: LoginException()