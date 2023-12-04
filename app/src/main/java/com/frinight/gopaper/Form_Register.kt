package com.frinight.gopaper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frinight.gopaper.data.AppDatabase
import com.frinight.gopaper.data.entity.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Form_Register : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var etNamaLengkap: EditText
    private lateinit var etNoHP: EditText
    private lateinit var editTextAlamat: EditText
    private lateinit var etPassword: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_register)

        // Inisialisasi elemen UI
        editTextEmail = findViewById(R.id.editTextEmail)
        etNamaLengkap = findViewById(R.id.etPasswordLogin)
        etNoHP = findViewById(R.id.etNoHP)
        editTextAlamat = findViewById(R.id.editTextAlamat)
        etPassword = findViewById(R.id.etPassword)
        checkBox = findViewById(R.id.checkBox)
        btnRegister = findViewById(R.id.btnLogin)

        // Menangani klik tombol Register
        btnRegister.setOnClickListener {
            if (validateInput()) {
                if (checkBox.isChecked) {
                    registerUser()
                } else {
                    showToast("Anda harus menyetujui persyaratan dan ketentuan.")
                }
            }
        }
    }

    private fun validateInput(): Boolean {
        if (editTextEmail.text.isBlank() || etNamaLengkap.text.isBlank() ||
            etNoHP.text.isBlank() || editTextAlamat.text.isBlank() || etPassword.text.isBlank()
        ) {
            showToast("Harap isi semua kolom.")
            return false
        }

        return true
    }

    private fun registerUser() {
        // Mendapatkan instance dari AppDatabase
        val appDatabase = AppDatabase.getInstance(this)

        if (validateInput()) {
            // Membuat objek User dari input pengguna
            val user = User(
                email = editTextEmail.text.toString(),
                fullName = etNamaLengkap.text.toString(),
                phoneNumber = etNoHP.text.toString(),
                address = editTextAlamat.text.toString(),
                password = etPassword.text.toString()
            )

            // Menjalankan operasi penggunaan Coroutine untuk menyimpan data pengguna ke database
            GlobalScope.launch {
                appDatabase.userDao().insertUser(user)
            }

            resetInputFields()
            showToast("Registrasi berhasil!")
            navigateToLoginScreen()  // Memanggil fungsi untuk pindah ke layar login
        }
    }


    private fun resetInputFields() {
        editTextEmail.text.clear()
        etNamaLengkap.text.clear()
        etNoHP.text.clear()
        editTextAlamat.text.clear()
        etPassword.text.clear()
        checkBox.isChecked = false
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(this, Form_Login::class.java)
        startActivity(intent)
        finish()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
