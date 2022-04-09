package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val btn_log_in = findViewById<Button>(R.id.btn_log_in)
        val et_id = findViewById<TextView>(R.id.et_id)
        val et_password = findViewById<TextView>(R.id.et_password)

        btn_log_in.setOnClickListener{
            if(et_id.text.isEmpty()){
                Toast.makeText(this, "please enter your Customer ID", Toast.LENGTH_SHORT).show()
            }
            else if(et_password.text.isEmpty()){
                Toast.makeText(this, "please enter your Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,AccountScreen1::class.java);
                startActivity(intent)
            }
        }
    }
}