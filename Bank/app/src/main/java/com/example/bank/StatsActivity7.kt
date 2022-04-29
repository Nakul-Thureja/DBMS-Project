package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class StatsActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats7)
        val result1 : TextView = findViewById(R.id.result1)
        val ID = intent.getStringExtra("ID")
        val branch = intent.getStringExtra("branch")
        val pass = intent.getStringExtra("password")
        val resultss = GetTextSQL(ID!!,pass!!, branch!!)
        var printer = ""
        var i = 0
        do{
            printer = printer + "BranchNo: "+resultss[i].BranchNo+"\nTotal Balance: "+ resultss[i].Sum+ "\n\n"
            i++
        }while(i < resultss.size)
        result1.text = printer


    }

    fun GetTextSQL(id : String, pass : String,branch:String) : ArrayList<Stats7Data> {
        val data = ArrayList<Stats7Data>()
        var today = ""
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                println("hello")

                val query: String =
                    "Select SUM(balance) as totalbalance,BranchNo from Accounts group by branchNO order by totalbalance DESC"
                val st: Statement = connect.createStatement()
                val rs: ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                } else {
                    do {
                        val temp = rs.getString(1)
                        val temp2 = rs.getString(2)

                        data.add(Stats7Data(temp, temp2))
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