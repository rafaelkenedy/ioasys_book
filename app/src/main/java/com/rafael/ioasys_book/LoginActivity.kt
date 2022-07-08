package com.rafael.ioasys_book

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvError = findViewById<AppCompatTextView>(R.id.tvError)

        val enterButton = findViewById<MaterialButton>(R.id.enterButton)

        enterButton.setOnClickListener {
            tvError.visibility = View.VISIBLE
        }

    }
}
