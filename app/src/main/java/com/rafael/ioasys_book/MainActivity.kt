package com.rafael.ioasys_book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafael.ioasys_book.databinding.ActivityMainBinding

//Single Activity hospedando fragments
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
