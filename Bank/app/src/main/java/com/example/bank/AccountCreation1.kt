package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class AccountCreation1 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var courses = arrayOf<String?>("C", "Data structures",
        "Interview prep", "Algorithms",
        "DSA with java", "OS")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation1)
        val tvAccType: TextView = findViewById(R.id.accType)
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = this
        val type = intent.getStringExtra("type");

        tvAccType.setText(type)
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            courses
        )
        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = ad

    }


    override fun onItemSelected(parent: AdapterView<*>?,
                                view: View, position: Int,
                                id: Long) {

        Toast.makeText(applicationContext,
            courses[position],
            Toast.LENGTH_LONG)
            .show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}