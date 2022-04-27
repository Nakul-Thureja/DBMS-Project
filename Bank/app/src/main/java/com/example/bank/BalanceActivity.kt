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
        val pass = intent.getStringExtra("pass")
        balance.text = "You have Rs."+ GetTextSQL(CID!!,pass!!)+" in your Account"
    }


    fun GetTextSQL(id : String, pass : String) : String {
        var data = ""
        try{
            val connectionhelper : ConnectionHelperUser = ConnectionHelperUser()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query : String = "Select Balance from Customer_view,Accounts_view where Accounts_view.CID = $id and Customer_view.CID = Accounts_view.CID"
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