package com.frinight.gopaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class Pick_Up3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_up3)

        val backButton: ImageView = findViewById(R.id.imgbtn_x)

        backButton.setOnClickListener {
            finish()
        }

        val close = findViewById<ImageButton>(R.id.imgbtn_x)
        close.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}