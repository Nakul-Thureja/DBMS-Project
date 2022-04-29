package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class StatsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats2)

        val result1 : TextView = findViewById(R.id.result1)
        val ID = intent.getStringExtra("ID")
        val acc_no = intent.getStringExtra("branch")
        val pass = intent.getStringExtra("password")
        val resultss = GetTextSQL(ID!!,pass!!, acc_no!!)
        var printer = ""
        var i = 0
        do{
            printer = printer + "Account No: "+ resultss[i].AccNo + "\n Name: "+ resultss[i].name + "\n Email: "+resultss[i].Email + "\n Card No: "+ resultss[i].CardNo + "\n Expiry Date: "+resultss[i].ExpDate+"\n\n"
            i++
        }while(i < resultss.size)
        result1.text = printer


    }

    fun GetTextSQL(id : String, pass : String,acc_no:String) : ArrayList<Stats2Data> {
        val data = ArrayList<Stats2Data>()
        var today = ""
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                println("hello")
                val query0: String = "SELECT CAST( GETDATE() AS Date )"
                val st0: Statement = connect.createStatement()
                val rs0: ResultSet = st0.executeQuery(query0)
                if (!rs0.next()) {
                    println("ResultSet isss empty in Java")
                } else {
                    do {
                        today = rs0.getString(1);
                    } while (rs0.next())
                    var expyear = today.subSequence(0, 4).toString().toInt()
                    expyear += 1
                    val expfinal = expyear.toString() + today.subSequence(4, 10)
                    expyear += 1
                    val expfinal2 = expyear.toString() + today.subSequence(4, 10)


                    val query: String =
                        "select A.AccNo,c.name,c.Email,cd.CardNo,cd.ExpDate from Accounts A,Customer C, Cards Cd " +
                                "where c.cid = a.cid and A.AccNo = CD.AccNo  and " +
                                "Cd.ExpDate between '$expfinal' and '$expfinal2' " +
                                "order by cd.ExpDate"
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
                            val temp5 = rs.getString(5)
                            println(temp)
                            println(temp2)
                            data.add(Stats2Data(temp, temp2, temp3, temp4, temp5))
                        } while (rs.next())
                    }
                    return data

                }
            }
        }
        catch (e:Exception){
            Log.e("Errorss", e.message!!)
        }
        return data
    }
}