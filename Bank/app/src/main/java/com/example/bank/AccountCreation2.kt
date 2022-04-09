package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class AccountCreation2 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var courses = arrayOf<String?>(
        "C", "Data structures",
        "Interview prep", "Algorithms",
        "DSA with java", "OS"
    )

    var loanType = arrayOf<String?>(
        "Home","Car","Personal"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation2)


        val spinner: Spinner = findViewById(R.id.spinner)
        val spinner2: Spinner = findViewById(R.id.spinner2)

        spinner.onItemSelectedListener = this

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            courses
        )

        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner.adapter = ad
        val ad2: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            loanType
        )

        ad2.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner2.adapter = ad2
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