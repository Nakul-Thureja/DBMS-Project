package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sign_in: Button = findViewById(R.id.btn_sign_in)
        val sign_up: Button = findViewById(R.id.btn_sign_up)
        val btn_emp: Button = findViewById(R.id.btn_emp)

        sign_in.setOnClickListener {
            SignIn(it)
        }
        sign_up.setOnClickListener {
            SignUp(it)
        }
        btn_emp.setOnClickListener {
            EmpPage(it)
        }
    }

    fun SignIn(view: View) {
        val intent = Intent(this,SignIn::class.java);
        startActivity(intent)
    }

    fun SignUp(view: View) {
        val intent = Intent(this,SignUp::class.java);
        startActivity(intent)
    }

    fun EmpPage(view: View) {
        val intent = Intent(this,EmployeeSigninActivity::class.java);
        startActivity(intent)
    }
}