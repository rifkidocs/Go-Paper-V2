package com.frinight.gopaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ArtikelEdukasi1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel_edukasi1)

        val backButton: Button = findViewById(R.id.back)

        backButton.setOnClickListener {
            finish()
        }
    }
}
