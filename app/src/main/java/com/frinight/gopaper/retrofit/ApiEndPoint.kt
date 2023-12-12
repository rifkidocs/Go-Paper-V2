package com.frinight.gopaper.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiEndPoint {
    @POST("api/v1/users")
    fun postUsers(@Body user: FormLoginModel): Call<FormLoginModel>
}
