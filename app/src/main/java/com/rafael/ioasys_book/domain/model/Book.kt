package com.rafael.ioasys_book.domain.model

data class Book(
    val id: Int,
    val name: String,
    val author: String,
    val pages: String,
    val editor: String,
    val date: String,
    val isbn10: String = "Sample",
    val isbn13: String = "Sample",
    val language: String = "Sample",
    val review: String = "Sample",
    val originName: String = "Sample"
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

        fun getMockListCount(count: Int): List<Book> {
            val mocklist = mutableListOf<Book>()
            for (i in 1..count) {
                mocklist.add(
                    Book(
                        id = i,
                        name = "Livro título ${i}",
                        author = "Francisco da Silva",
                        pages = "150 páginas",
                        editor = "Editora Loyola",
                        date = "Publicado em 2020"
                    )
                )
            }
            return mocklist
        }
    }
}