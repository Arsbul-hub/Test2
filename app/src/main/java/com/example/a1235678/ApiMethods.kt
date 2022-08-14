package com.example.a1235678


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
data class LoginData(val email: String, val password: String)
data class RegisterData(val email: String, val password: String, val firstName: String, val lastname: String)
data class Out(val token: String)

interface ApiMethods {
    @POST("auth/login")
    fun login(@Body body: LoginData): Call<Out>
    @POST("auth/register")
    fun register(@Body body: RegisterData): Call<Out>
}