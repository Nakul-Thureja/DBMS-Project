package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class BalanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)
        val balance : TextView = findViewById(R.id.balance)
        val CID = intent.getStringExtra("CID")
        val acc_no = intent.getStringExtra("Acc")
        val pass = intent.getStringExtra("pass")
        balance.text = "You have Rs."+ GetTextSQL(CID!!,pass!!, acc_no!!)+" in your Account"
    }


    fun GetTextSQL(id : String, pass : String,acc_no:String) : String {
        var data = ""
        try{
            val connectionhelper : ConnectionHelperUser = ConnectionHelperUser()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query : String = "Select Balance from Accounts_view where AccNo = $acc_no"
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