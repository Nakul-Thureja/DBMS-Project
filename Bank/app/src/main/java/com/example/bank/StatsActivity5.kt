package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class StatsActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats5)
        val result1 : TextView = findViewById(R.id.result1)
        val ID = intent.getStringExtra("ID")
        val acc_no = intent.getStringExtra("branch")
        val pass = intent.getStringExtra("password")
        val resultss = GetTextSQL(ID!!,pass!!, acc_no!!)
        var printer = ""
        var i = 0
        do{
            printer = printer + "Rank: "+resultss[i].rank+"\nAsset Type: "+ resultss[i].Type+"\nRate of Interest: "+ resultss[i].ROI + "\n\n"
            i++
        }while(i < resultss.size)
        result1.text = printer


    }

    fun GetTextSQL(id : String, pass : String,acc_no:String) : ArrayList<Stats5Data> {
        val data = ArrayList<Stats5Data>()
        var today = ""
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                println("hello")

                val query: String =
                    "SELECT Type, ROI, DENSE_RANK() OVER(ORDER BY ROI DESC) Rank FROM Rates ORDER BY Rank"
                val st: Statement = connect.createStatement()
                val rs: ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                } else {
                    do {
                        val temp = rs.getString(1)
                        val temp2 = rs.getString(2)
                        val temp3 = rs.getString(3)

                        data.add(Stats5Data(temp, temp2, temp3))
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