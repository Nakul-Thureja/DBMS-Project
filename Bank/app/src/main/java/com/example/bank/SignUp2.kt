package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SignUp2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)
        val next: Button = findViewById(R.id.btn_next)
        next.setOnClickListener {
            nextPage(it)
        }

    }

    fun nextPage(it: View) {
        val intent = Intent(this,SignUp3::class.java);
        startActivity(intent)
    }
}