package com.frinight.gopaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Pick_Up1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_up1)

        val backButton: ImageView = findViewById(R.id.imgbtn_exit)

        backButton.setOnClickListener {
            finish()
        }
    }
}