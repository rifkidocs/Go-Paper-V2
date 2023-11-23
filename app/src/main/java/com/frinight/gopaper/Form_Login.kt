package com.frinight.gopaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frinight.gopaper.databinding.ActivityFormLoginBinding

class Form_Login : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvsignUp.setOnClickListener{
            val intent = Intent(this, Form_Register::class.java)
            startActivity(intent)
        }

    }
}