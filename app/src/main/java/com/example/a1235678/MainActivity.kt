package com.example.a1235678

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_screen.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object Api {
    val db = Retrofit.Builder().baseUrl("http://cinema.areas.su/").addConverterFactory(
        ScalarsConverterFactory.create()
    ).addConverterFactory(GsonConverterFactory.create()).build()
    val db2 = Retrofit.Builder().baseUrl("http://cinema.areas.su/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val api = db.create(ApiMethods::class.java)
    val api2 = db2.create(ApiMethods::class.java)
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}