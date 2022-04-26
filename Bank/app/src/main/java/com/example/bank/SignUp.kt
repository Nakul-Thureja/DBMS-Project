package com.example.bank

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.text.SimpleDateFormat
import java.util.*

class SignUp : AppCompatActivity(), AdapterView.OnItemSelectedListener  {
    var gender = arrayOf<String?>("Male", "Female",
        "Other")
    var date: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = this
        val next: Button = findViewById(R.id.btn_next)
        val et_name = findViewById<TextView>(R.id.et_name)
        val et_phone = findViewById<TextView>(R.id.et_phone)
        val et_email = findViewById<TextView>(R.id.et_email)
        val btn_date = findViewById<Button>(R.id.btn_date)
        btn_date.setOnClickListener { clickDatePicker(it) }


        next.setOnClickListener {
            nextPage(it,et_name.text.toString(),et_phone.text.toString(),
            et_email.text.toString())
        }
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            gender
        )
        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = ad
    }

    fun nextPage(it: View, et_name:String,et_phone:String,et_email:String) {
        val intent = Intent(this,SignUp2::class.java);
        println(et_name)
        intent.putExtra("Name",et_name)
        intent.putExtra("Phone",et_phone)
        intent.putExtra("Email",et_email)
        if(date!=null) {
            intent.putExtra("Dob", date)
        }
        startActivity(intent)
    }


    override fun onItemSelected(parent: AdapterView<*>?,
                                view: View, position: Int,
                                id: Long) {

        Toast.makeText(applicationContext,
            gender[position],
            Toast.LENGTH_LONG)
            .show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    fun clickDatePicker(view: View) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                date = "$year-${monthOfYear+1}-$dayOfMonth"
            },
            year,
            month,
            day
        )
        datePickerDialog.datePicker.setMaxDate(Date().time)
        datePickerDialog.show()
    }

}