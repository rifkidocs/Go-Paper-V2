package com.frinight.gopaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SaldoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saldo)

        val backButton: ImageView = findViewById(R.id.back)

        backButton.setOnClickListener {
            finish()
        }
    }
}