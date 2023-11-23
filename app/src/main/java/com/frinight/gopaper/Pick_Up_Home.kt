package com.frinight.gopaper

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Pick_Up_Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_up_home)

        val pilih = findViewById<View>(R.id.pickih1)
        pilih.setOnClickListener {
            val intent = Intent(this, Pick_Up1::class.java)
            startActivity(intent)
        }

        val kertasbtn = findViewById<View>(R.id.pickv)
        kertasbtn.setOnClickListener {
            val intent = Intent(this, Pick_Up2::class.java)
            startActivity(intent)
        }
    }
}
