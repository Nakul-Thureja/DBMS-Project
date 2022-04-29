package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class StatsActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats6)
        val result1 : TextView = findViewById(R.id.result1)
        val ID = intent.getStringExtra("ID")
        val branch = intent.getStringExtra("branch")
        val pass = intent.getStringExtra("password")
        val resultss = GetTextSQL(ID!!,pass!!, branch!!)
        var printer = ""
        var i = 0
        do{
            printer = printer + "Name: "+resultss[i].Name+"\nAddress: "+ resultss[i].Address+"\nPhoneNo: "+ resultss[i].PhoneNo + "\nEmail: "+resultss[i].Email+"\n\n"
            i++
        }while(i < resultss.size)
        result1.text = printer


    }

    fun GetTextSQL(id : String, pass : String,branch:String) : ArrayList<Stats6Data> {
        val data = ArrayList<Stats6Data>()
        var today = ""
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                println("hello")

                val query: String =
                    "SELECT Name,Address,PhoneNo,Email from Customer Inner Join Accounts ON Customer.CID = Accounts.CID and Accounts.BranchNo = $branch"
                val st: Statement = connect.createStatement()
                val rs: ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                } else {
                    do {
                        val temp = rs.getString(1)
                        val temp2 = rs.getString(2)
                        val temp3 = rs.getString(3)
                        val temp4 = rs.getString(4)

                        data.add(Stats6Data(temp, temp2, temp3,temp4))
                    } while (rs.next())
                }
                return data

            }
        }
        catch (e:Exception){
            Log.e("Errorss", e.message!!)
        }
        return data
    }
}