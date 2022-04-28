package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.sql.Connection
import java.sql.Statement

class SalaryChange : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salary_change)
       val ID = intent.getStringExtra("ID")
            val pass = intent.getStringExtra("pass")
        val branch = intent.getStringExtra("branch")
            val emp_id = intent.getStringExtra("EmpID")
            val bt : Button = findViewById(R.id.btn_change)
            val et_amount : TextView = findViewById(R.id.et_amt)

        bt.setOnClickListener {
                val amount = et_amount.text.toString()
                    updateBalance(ID!!, pass!!, emp_id!!,amount)
                val intent = Intent(this, Main4Activity::class.java)

                    intent.putExtra("ID",ID);
                    intent.putExtra("password",pass)
                    intent.putExtra("branch",branch)
                    startActivity(intent)

            }
        }


        fun updateBalance(id: String, pass: String, empID: String, amount:String) {
            try {

                val connectionhelper: ConnectionHelperManager = ConnectionHelperManager()
                val connect: Connection = connectionhelper.connectionclass(id, pass)
                if (connect != null) {


                        val query: String =
                            "Update manager_employee_view set Salary = $amount where empID = $empID"
                        val st: Statement = connect.createStatement()
                        val rs: Int = st.executeUpdate(query)


                }
            } catch (e: Exception) {
                Log.e("Errorss", e.message!!)
            }
            Toast.makeText(this, "The salary was updated", Toast.LENGTH_SHORT).show()

        }

    }