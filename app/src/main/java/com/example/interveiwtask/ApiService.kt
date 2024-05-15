package com.example.interveiwtask


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("api/login")
    fun login(
        @Body requestBody: LoginRequest
    ): Call<LoginResponse>

    @GET("api/users?page=2")
    fun getUsers(): Call<UserResponse>
}

