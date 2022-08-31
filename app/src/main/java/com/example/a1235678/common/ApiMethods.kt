package com.example.a1235678


import android.annotation.SuppressLint
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
data class LoginData(val email: String, val password: String)
data class RegisterData(val email: String, val password: String, val firstName: String, val lastName: String)
data class CoverData(val movieId: String, val backgroundImage: String, val foregroundImage: String)
data class Out(val token: String)

interface ApiMethods {
    @POST("auth/login")
    fun login(@Body body: LoginData): Call<Out>
    @POST("auth/register")
    fun register(@Body body: RegisterData): Call<String>
    @POST("movies/cover")
    fun cover(): Call<CoverData>
//    @POST("user/auth")
//    fun check(@Body email: String): Call<Out>
}
//fun check_user(email: String) {
//    Api.api.check(email).enqueue(object : Callback<Out> {
//        override fun onResponse(call: Call<Out>, response: Response<Out>) {
//            if (response.body() != null) {
//                Log.e("d", response.body()!!.token)
//            }
//        }
//
//        override fun onFailure(call: Call<Out>, t: Throwable) {
//            Log.e("d", t.message!!.toString())
//        }
//
//    })
//}
fun login(body: LoginData, callback: Callback<Out>) : String {
    var out = ""
    Api.api.login(body)
        .enqueue(callback)
    return out
}

fun register(body: RegisterData): String {
    var out = ""
    Api.api.register(body).enqueue(object : Callback<String> {
        @SuppressLint("SetTextI18n")
        override fun onResponse(call: Call<String>, response: Response<String>) {
            if (response.body() != null) {
                //val output = Gson().fromJson(response.body(), Out::class.java)
                Log.e("12344", response.body()!!)
            }
            else {
                Log.e("12344", "response.body() = null")
            }
        }

        override fun onFailure(call: Call<String>, t: Throwable) {
            Log.e("error_r", t.message.toString())
            //out = login(LoginData(email = body.email, password = body.password))
        }

    })
    return out
}

fun getCover(): CoverData{
    var out = CoverData("", "", "")
    Api.api.cover().enqueue(object: Callback<CoverData> {
        //@SuppressLint("SetTextI18n")
        override fun onResponse(call: Call<CoverData>, response: Response<CoverData>) {
            Log.e("e", response.body().toString())
            if (response.body() != null) {
               out = response.body()!!
            }
            Log.e("mess", response.message())
        }

        override fun onFailure(call: Call<CoverData>, t: Throwable) {
            Log.e("mess", t.message.toString())
        }

    })
    return out
}