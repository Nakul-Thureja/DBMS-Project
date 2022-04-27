package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager)
        val btn_log_in = findViewById<Button>(R.id.btn_log_in)
        btn_log_in.setOnClickListener {
            val intent = Intent(this, Main4Activity::class.java);
            //add data
            startActivity(intent)
        }
    }
}