package com.rafael.ioasys_book.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rafael.ioasys_book.R
import com.rafael.ioasys_book.model.Book

class BookListAdapter : ListAdapter<Book, BookListAdapter.BookListViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean =
                oldItem == newItem
        }
    }


    class BookListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val bookTitle: AppCompatTextView = view.findViewById(R.id.tvBookTitle)
        private val bookAuthor: AppCompatTextView = view.findViewById(R.id.tvBookAuthor)
        private val bookPages: AppCompatTextView = view.findViewById(R.id.tvPages)
        private val bookEditor: AppCompatTextView = view.findViewById(R.id.tvBookEditor)
        private val bookDate: AppCompatTextView = view.findViewById(R.id.tvBookDate)

        fun bind(book: Book) {
            bookTitle.text = book.name
            bookAuthor.text = book.author
            bookPages.text = book.pages
            bookEditor.text = book.editor
            bookDate.text = book.date
        }

        companion object {
            fun create(parent: ViewGroup): BookListViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
                return BookListViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        return BookListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}