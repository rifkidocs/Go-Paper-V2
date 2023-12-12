package com.frinight.gopaper.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndPoint {
    @POST("api/v1/users")
    fun postUsers(@Body user: FormRegisterModel): Call<FormRegisterModel>

    @POST("api/v1/users/login")
    fun login(@Body loginModel: FormLoginModel): Call<LoginResponse>
}