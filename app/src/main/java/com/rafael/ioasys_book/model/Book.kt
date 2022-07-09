package com.rafael.ioasys_book.model

data class Book(
    val id: Int,
    val name: String,
    val author: String,
    val pages: String,
    val editor: String,
    val date: String
) {
    companion object {
        fun getBookList() = listOf(
            Book(
                id = 1,
                name = "Livro de Título A",
                author = "Francisco da Silva",
                pages = "150 páginas",
                editor = "Editora Loyola",
                date = "Publicado em 2020"
            ),
            Book(
                id = 2,
                name = "Livro de Título B",
                author = "Francisco da Silva",
                pages = "150 páginas",
                editor = "Editora Loyola",
                date = "Publicado em 2020"
            )
        )
    }
}