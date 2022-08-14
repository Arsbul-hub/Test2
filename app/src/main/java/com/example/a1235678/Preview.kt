package com.example.a1235678

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Preview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        Handler().postDelayed({startActivity(Intent(this@Preview, MainActivity:: class.java))}, 1500)
    }
}