package com.frinight.gopaper.retrofit

data class FormRegisterModel(
    val nama: String,
    val email: String,
    val no_hp: String,
    val alamat: String,
    val password: String,
    val about: String?,
    val profil: String?,
    val background: String?,
    val language: String
)

