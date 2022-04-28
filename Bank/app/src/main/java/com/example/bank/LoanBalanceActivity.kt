package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.bank.ConnectionHelperUser
import com.example.bank.R
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class LoanBalanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_balance)
        val balance : TextView = findViewById(R.id.balance)
        val CID = intent.getStringExtra("CID")
        val acc_no = intent.getStringExtra("Acc")
        val pass = intent.getStringExtra("pass")
        balance.text = "Your Remaining Amount in Loan is Rs."+ GetTextSQL(CID!!,pass!!, acc_no!!)
    }


    fun GetTextSQL(id : String, pass : String,acc_no:String) : String {
        var data = ""
        try{
            val connectionhelper : ConnectionHelperUser = ConnectionHelperUser()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query: String = "Select RemainingAmount from Loan_view where LoanID = $acc_no"
                val st : Statement = connect.createStatement()
                val rs : ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                }
                else {
                    do {
                        data = rs.getString(1)
                    } while (rs.next()) }
                return data

            }
        }
        catch (e:Exception){
            Log.e("Errorss", e.message!!)
        }
        return data
    }
}