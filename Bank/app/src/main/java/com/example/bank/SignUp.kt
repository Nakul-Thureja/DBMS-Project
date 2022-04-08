package com.example.bank

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val next: Button = findViewById(R.id.btn_next)

        next.setOnClickListener {
            nextPage(it)
        }

    }

    fun nextPage(it: View) {
        val intent = Intent(this,SignUp2::class.java);
        startActivity(intent)
    }

    fun clickDatePicker(view: View) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                val dateValue = "$dayOfMonth/${monthOfYear+1}/$year"
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val birthDate = sdf.parse(dateValue)
            },
            year,
            month,
            day
        )
        datePickerDialog.datePicker.setMaxDate(Date().time)
        datePickerDialog.show()
    }

}