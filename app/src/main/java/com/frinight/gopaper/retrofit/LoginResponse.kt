package com.frinight.gopaper.retrofit

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val data: List<UserResponse>?
)

data class UserResponse(
    val id: Long,
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