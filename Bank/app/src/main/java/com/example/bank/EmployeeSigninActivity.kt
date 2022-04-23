package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EmployeeSigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_signin)
        val btn_emp : Button = findViewById(R.id.btn_emp)
        val btn_man : Button = findViewById(R.id.btn_man)
        btn_emp.setOnClickListener {
            val intent = Intent(this,EmployeeActivity::class.java);
            startActivity(intent)
        }
        btn_man.setOnClickListener {
            val intent = Intent(this,ManagerActivity::class.java);
            startActivity(intent)
        }
    }
}