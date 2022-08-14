package com.example.a1235678

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    val db = Retrofit.Builder().baseUrl("http://cinema.areas.su/").addConverterFactory(GsonConverterFactory.create()).build()
    val api = db.create(ApiMethods::class.java)
}

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register(
            RegisterData(
                email = "vasya1@mail.com",
                password = "qwerty",
                firstName = "John",
                lastname = "Johnson"
            )
        )

    }

    fun login(body: LoginData) {
        Api.api.login(body)
            .enqueue(object : Callback<Out> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<Out>, response: Response<Out>) {
                    val body = response.body()
                    if (body != null) {
                        state.setText("Ваш токен ${body.token}")

                    }
                }

                override fun onFailure(call: Call<Out>, t: Throwable) {

                    state.setText(t.message)
                }
            })
    }

    fun register(body: RegisterData) {
        Api.api.register(body).enqueue(object : Callback<Out> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Out>, response: Response<Out>) {

            }

            override fun onFailure(call: Call<Out>, t: Throwable) {
                login(LoginData(email = "vasya21@mail.com", password = "qwerty"))
            }

        })
    }
}