package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class MBalanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance)
        val balance : TextView = findViewById(R.id.balance)
        val ID = intent.getStringExtra("ID")
        val acc_no = intent.getStringExtra("Acc")
        val pass = intent.getStringExtra("pass")
        println(pass)
        println(acc_no)
        println(ID)
        balance.text = "Customer has Rs."+ GetTextSQL(ID!!,pass!!, acc_no!!)+" in their Account"
    }


    fun GetTextSQL(id : String, pass : String,acc_no:String) : String {
        var data = ""
        try{
            val connectionhelper : ConnectionHelperManager = ConnectionHelperManager()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                println("hello")
                val query : String = "Select Balance from manager_accounts_view where AccNo = $acc_no"
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