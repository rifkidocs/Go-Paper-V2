package com.frinight.gopaper

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frinight.gopaper.Form_Register
import com.frinight.gopaper.MainActivity
import com.frinight.gopaper.data.AppDatabase
import com.frinight.gopaper.databinding.ActivityFormLoginBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Form_Login : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
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
            loginUser()
        }

        binding.tvsignUp.setOnClickListener {
            val intent = Intent(this, Form_Register::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser() {
        val email = binding.editTextEmail.text.toString()
        val password = binding.etPasswordLogin.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            showToast("Email dan password wajib diisi")
            return
        }

        val appDatabase = AppDatabase.getInstance(this)

        GlobalScope.launch {
            val user = appDatabase.userDao().getUserByEmail(email)
            if (user != null) {
                if (user.password == password) {
                    showToast("Login berhasil")
                    saveLoginState(user.uid, email, password)  // Simpan informasi login
                    navigateToMainActivity()
                } else {
                    showToast("Email atau password tidak valid")
                }
            } else {
                showToast("Email atau password tidak valid")
            }
        }
    }

    private fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this@Form_Login, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveLoginState(userId: Long, email: String, password: String) {
        // Simpan informasi login ke SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", true)
        editor.putLong("userId", userId)
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
