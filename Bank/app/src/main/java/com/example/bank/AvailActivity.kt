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

class AvailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avail)
        val CID = intent.getStringExtra("CID")
        val pass = intent.getStringExtra("pass")
        val acc_no = intent.getStringExtra("Acc")
        val bt : Button = findViewById(R.id.btn_avail)
        val et_amount : TextView = findViewById(R.id.et_amt)
        bt.setOnClickListener {
            val amount = et_amount.text.toString()
            var amount2 = GetTextSQL(CID!!,pass!!,amount,acc_no!!)
            amount2 -= amount.toInt()
            if(amount2<0){
                Toast.makeText(this, "Can't deduct more amount than balance", Toast.LENGTH_SHORT).show()
            }
            else {
                updateBalance(CID!!, pass!!, amount2, acc_no,amount)
            }
        }
    }

    fun GetTextSQL(id : String, pass : String,amount:String,acc_no:String) :Int{
        var data = ""
    println("hello")
        try {
            val connectionhelper: ConnectionHelperUser = ConnectionHelperUser()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                val query0: String = "Select Balance from Accounts_view where AccNo = $acc_no"
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
                        "Update Accounts_view set Balance = $amount where AccNo = $acc_no"
                    val st: Statement = connect.createStatement()
                    val rs: Int = st.executeUpdate(query)

                    val query1: String =
                        "INSERT INTO Transactions (Tno,TransactionType,SenderAccNo,Amount,DOT,ReceiverAccNo) " +
                                "VALUES (10000000$counter,'Net-Banking',$acc_no,-$amountcut,'$today','')"
                    val st1: Statement = connect.createStatement()
                    val rs1: Int = st.executeUpdate(query1)
                }
            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
        Toast.makeText(this, "The Amount was deducted. Your new balance is $amount", Toast.LENGTH_SHORT).show()
        this.finish()

    }

    }
