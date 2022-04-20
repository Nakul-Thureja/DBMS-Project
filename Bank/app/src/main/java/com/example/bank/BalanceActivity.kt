package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BalanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)
        val balance : TextView = findViewById(R.id.balance)
        val num = intent.getIntExtra("AccNo",0)
        balance.text = "1000$num"
    }
}