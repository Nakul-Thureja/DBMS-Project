package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SignUp3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up3)
        val saving: Button = findViewById(R.id.btn_savings)
        val current: Button = findViewById(R.id.btn_current)
        val loan: Button = findViewById(R.id.btn_loan)
        val CID = intent.getStringExtra("CID")
        saving.setOnClickListener {
            SavingPage(it,CID!!)
        }
        current.setOnClickListener {
            CurrentPage(it,CID!!)
        }
        loan.setOnClickListener {
            LoanPage(it,CID!!)
        }

    }
    fun SavingPage(it: View, CID:String) {
        val intent = Intent(this,AccountCreation1::class.java);
        intent.putExtra("type","Savings")
        intent.putExtra("CID",CID)
        startActivity(intent)
    }
    fun CurrentPage(it: View, CID:String) {
        val intent = Intent(this,AccountCreation1::class.java);
        intent.putExtra("type","Current")
        intent.putExtra("CID",CID)
        startActivity(intent)
    }

    fun LoanPage(it: View, CID:String) {
        val intent = Intent(this,AccountCreation2::class.java);
        intent.putExtra("CID",CID)
        startActivity(intent)
    }
}