package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class LoanAvailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_avail)
        val CID = intent.getStringExtra("CID")
        val pass = intent.getStringExtra("pass")
        val acc_no = intent.getStringExtra("Acc")
        val bt : Button = findViewById(R.id.btn_repay)
        val et_amount : TextView = findViewById(R.id.et_lona_amount)
        bt.setOnClickListener {
            val amount = et_amount.text.toString()
            var amount2 = GetTextSQL(CID!!,pass!!,amount,acc_no!!)
            amount2 -= amount.toInt()
            if(amount2<0){
                Toast.makeText(this, "Can't deduct more amount than balance in account", Toast.LENGTH_SHORT).show()
            }
            else {
                updateBalance(CID!!, pass!!, amount2, acc_no,amount)
            }
        }
    }

    fun GetTextSQL(id : String, pass : String,amount:String,acc_no:String) :Int{
        var data = ""
        try {
            val connectionhelper: ConnectionHelperUser = ConnectionHelperUser()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                val query0: String = "Select RemainingAmount from Loan_view where LoanID = $acc_no"
                val st0: Statement = connect.createStatement()
                val rs0: ResultSet = st0.executeQuery(query0)
                if (!rs0.next()) {
                    println("ResultSet in empty in Java")
                } else {
                    do {
                        data = rs0.getString(1)
                    } while (rs0.next())
                }

            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
        return data.toInt()
    }

    fun updateBalance(id : String, pass : String, amount:Int,acc_no: String,amountcut:String) {
        try {
            var today = ""
            var counter = 0
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {

                val query0: String = "SELECT CAST( GETDATE() AS Date )"
                val st0: Statement = connect.createStatement()
                val rs0: ResultSet = st0.executeQuery(query0)
                if (!rs0.next()) {
                    println("ResultSet isss empty in Java")
                } else {
                    do {
                        today = rs0.getString(1);
                    } while (rs0.next())

                    val queryinit: String = "select count(*) from Transactions"
                    val stinit: Statement = connect.createStatement()
                    val rsinit: ResultSet = stinit.executeQuery(queryinit)
                    var count = "0";
                    while (rsinit.next()) {
                        count = rsinit.getString(1)
                    }
                    counter = count.toInt()
                    counter++

                    val query: String =
                        "Update loan_view set RemainingAmount = $amount where LoanID = $acc_no"
                    val st: Statement = connect.createStatement()
                    val rs: Int = st.executeUpdate(query)
                }
            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
        Toast.makeText(this, "The loan amount was repaid. Now remaining amount is $amount", Toast.LENGTH_SHORT).show()
        this.finish()

    }

}
