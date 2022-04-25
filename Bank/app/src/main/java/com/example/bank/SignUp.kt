package com.example.bank

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.text.SimpleDateFormat
import java.util.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val next: Button = findViewById(R.id.btn_next)
        val et_name = findViewById<TextView>(R.id.et_name)
        val et_phone = findViewById<TextView>(R.id.et_phone)
        val et_email = findViewById<TextView>(R.id.et_email)
        val et_dob = findViewById<TextView>(R.id.et_dob)


        next.setOnClickListener {
            nextPage(it,et_name.text.toString(),et_phone.text.toString(),
            et_email.text.toString(),et_dob.text.toString())
        }

    }

    fun nextPage(it: View, et_name:String,et_phone:String,et_email:String,et_dob:String) {
        val intent = Intent(this,SignUp2::class.java);
        println(et_name)
        intent.putExtra("Name",et_name)
        intent.putExtra("Phone",et_phone)
        intent.putExtra("Email",et_email)
        intent.putExtra("Dob",et_dob)
        startActivity(intent)
    }


}