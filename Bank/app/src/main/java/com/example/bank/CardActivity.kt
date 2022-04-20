package com.example.bank

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.bank.R.layout.activity_card)
        val cardNo : TextView = findViewById(com.example.bank.R.id.cardNo)
        val num = intent.getIntExtra("CardNo",0)
        cardNo.text = "Card No: $num"
        val b: Button = findViewById(com.example.bank.R.id.btn_requestcard)
        b.setVisibility(View.GONE)
    }
}