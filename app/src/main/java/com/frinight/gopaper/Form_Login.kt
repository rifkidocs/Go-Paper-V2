package com.frinight.gopaper

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frinight.gopaper.Form_Register
import com.frinight.gopaper.MainActivity
import com.frinight.gopaper.data.AppDatabase
import com.frinight.gopaper.databinding.ActivityFormLoginBinding
import com.frinight.gopaper.retrofit.ApiService
import com.frinight.gopaper.retrofit.FormLoginModel
import com.frinight.gopaper.retrofit.LoginResponse
import com.frinight.gopaper.retrofit.UserResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val apiService = ApiService.endPoint
        val loginModel = FormLoginModel(email)

        apiService.login(loginModel).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    Log.d("LoginResponse", "Response: $loginResponse")

                    if (loginResponse?.success == true) {
                        val userList = loginResponse.data
                        if (!userList.isNullOrEmpty()) {
                            val user = userList[0]
                            if (user.password == password) {
                                showToast("Login berhasil")
                                saveLoginState(user)
                                navigateToMainActivity()
                            } else {
                                showToast("Email atau password tidak valid")
                            }
                        } else {
                            showToast("Data pengguna tidak valid")
                        }
                    } else {
                        showToast("Email atau password tidak valid")
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("LoginError", "Error: $errorBody")
                    showToast("Gagal melakukan login")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                showToast("Gagal melakukan login: ${t.message}")
            }
        })
    }



    private fun saveLoginState(user: UserResponse?) {
        if (user != null) {
            // Simpan informasi login ke SharedPreferences
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", true)
            editor.putLong("userId", user.id)
            editor.putString("email", user.email)
            editor.putString("password", user.password)
            editor.putString("fullName", user.nama)
            editor.apply()
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this@Form_Login, message, Toast.LENGTH_SHORT).show()
        }
    }
}