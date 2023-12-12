package com.frinight.gopaper

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frinight.gopaper.data.entity.User
import com.frinight.gopaper.retrofit.ApiService
import com.frinight.gopaper.retrofit.FormRegisterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        if (validateInput()) {
            val user = User(
                email = editTextEmail.text.toString(),
                fullName = etNamaLengkap.text.toString(),
                phoneNumber = etNoHP.text.toString(),
                address = editTextAlamat.text.toString(),
                password = etPassword.text.toString()
            )

            registerUserToApi(FormRegisterModel(
                user.fullName ?: "",
                user.email ?: "",
                user.phoneNumber ?: "",
                user.address ?: "",
                user.password,
                "tell me about yourself",
                null,
                null,
                "ID"
            ))
        }
    }


    private fun registerUserToApi(user: FormRegisterModel) {
        val apiService = ApiService.endPoint
        val call: Call<FormRegisterModel> = apiService.postUsers(user)

        call.enqueue(object : Callback<FormRegisterModel> {
            override fun onResponse(call: Call<FormRegisterModel>, response: Response<FormRegisterModel>) {
                if (response.isSuccessful) {
                    showToast("Pendaftaran Berhasil Silahkan Login")
                    resetInputFields()
                    navigateToLoginScreen()
                } else {
                    showToast("Gagal mendaftarkan pengguna ${response.errorBody()?.string()}")
                    Log.d("RegisterApi", "onResponse:${response.errorBody()?.string()}")
                    println("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<FormRegisterModel>, t: Throwable) {
                showToast("Gagal mendaftarkan pengguna ${t.message}")
                Log.d("ErroApi","Gagal mendaftarkan pengguna ${t.message}")
            }
        })
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
