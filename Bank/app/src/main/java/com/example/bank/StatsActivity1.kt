package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class StatsActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats1)
        val result1 : TextView = findViewById(R.id.result1)
        val ID = intent.getStringExtra("ID")
        val acc_no = intent.getStringExtra("branch")
        val pass = intent.getStringExtra("password")
        val resultss = GetTextSQL(ID!!,pass!!, acc_no!!)
        var printer = ""
        var i = 0
        do{
            printer = printer + "For Branch - "+ resultss[i].branch + "\n Maximum Salary is - Rs. "+ resultss[i].salary + "\n\n"
            i++
        }while(i < resultss.size)
        result1.text = printer


    }

    fun GetTextSQL(id : String, pass : String,acc_no:String) : ArrayList<Stats1Data> {
        val data = ArrayList<Stats1Data>()
        try{
            val connectionhelper : ConnectionHelper = ConnectionHelper()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                println("hello")
                val query : String = "select B.BranchNo,Max(E.salary) as MaxSalary from Branch B,Employee E,Works W " +
                        "where W.BranchNo = B.BranchNo and E.EmpID = W.EmpID" +
                        " group by B.BranchNo"
                val st : Statement = connect.createStatement()
                val rs : ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                }
                else {
                    do {
                        val temp = rs.getString(1)
                        val temp2 = rs.getString(2)
                        println(temp)
                        println(temp2)
                        data.add(Stats1Data(temp,temp2))
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