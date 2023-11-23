package com.frinight.gopaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Pick_Up2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_up2)

        val next = findViewById<View>(R.id.pickv2)
        next.setOnClickListener {
            val intent = Intent(this, Pick_Up3::class.java)
            startActivity(intent)
        }
    }
}