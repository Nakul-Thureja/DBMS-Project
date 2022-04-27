package com.example.bank

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import java.util.*
import kotlin.collections.ArrayList

class PassbookActivity : AppCompatActivity() {
    var date1: String? = null;
    var date2: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passbook)
        val et_date1 = findViewById<TextView>(R.id.et_date1)
        val et_date2 = findViewById<TextView>(R.id.et_date2)
        val CID = intent.getStringExtra("CID")
        val acc_no = intent.getStringExtra("Acc")
        val pass = intent.getStringExtra("pass")
        et_date1.visibility = View.INVISIBLE
        et_date2.visibility = View.INVISIBLE

        val filter = findViewById<Button>(R.id.btn_Filter)
        filter.setOnClickListener {
            clickDatePicker(it, et_date1 , et_date2  ,filter)
        }
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val items = fetchData(CID!!,pass!!,acc_no!!)
        val adapter: PassbookAdapter = PassbookAdapter(items)
        recyclerView.adapter = adapter
    }

    private fun fetchData(id : String, pass : String,acc_no:String): ArrayList<TransactionData> {
        return GetTextSQL(id,pass,acc_no)
    }

    fun clickDatePicker(view: View, et_date1: TextView, et_date2: TextView, btn_Filter: Button) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog1 = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                date1 = "$year-${monthOfYear+1}-$dayOfMonth"
                et_date1.visibility = View.VISIBLE
                et_date1.text = "FROM - "+date1
                btn_Filter.visibility = View.INVISIBLE
            },
            year,
            month,
            day
        )
        datePickerDialog1.datePicker.setMaxDate(Date().time)

        val datePickerDialog2 = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                date2 = "$year-${monthOfYear+1}-$dayOfMonth"
                et_date2.visibility = View.VISIBLE
                et_date2.text = "TO - "+date2
                btn_Filter.visibility = View.INVISIBLE
            },
            year,
            month,
            day
        )
        datePickerDialog2.datePicker.setMaxDate(Date().time)
        datePickerDialog2.show()
        datePickerDialog1.show()

        et_date1.visibility = View.VISIBLE
        et_date2.visibility = View.VISIBLE
        et_date1.text = date1
        et_date1.text = date2
        btn_Filter.visibility = View.INVISIBLE

    }

    fun GetTextSQL(id : String, pass : String,acc_no:String) : ArrayList<TransactionData> {
        var data = ArrayList<TransactionData>()
        try{
            val connectionhelper : ConnectionHelperUser = ConnectionHelperUser()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query : String = "Select TNo,amount,DOT,TransactionType,SenderAccNo,ReceiverAccno from transactions_view where SenderAccNo = $acc_no or ReceiverAccNo = $acc_no"
                val st : Statement = connect.createStatement()
                val rs : ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                }
                else {
                    do {
                        var temp :TransactionData
                        if(rs.getString(6) != null && rs.getString(6) != "0"){
                             temp = TransactionData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6))

                        }
                        else{
                            temp = TransactionData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),"Self")

                        }
                        data.add(temp)
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