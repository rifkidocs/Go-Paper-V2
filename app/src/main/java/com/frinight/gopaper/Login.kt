package com.frinight.gopaper

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frinight.gopaper.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("login_prefs", Context.MODE_PRIVATE)

        // Cek apakah user sudah login sebelumnya
        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            // Jika sudah login, pindah ke MainActivity atau halaman yang sesuai
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Tutup activity saat ini agar tidak bisa kembali ke halaman login
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, Form_Login::class.java)
            startActivity(intent)
        }

        binding.tvsignUp.setOnClickListener {
            val intent = Intent(this, Form_Register::class.java)
            startActivity(intent)
        }
    }
}
