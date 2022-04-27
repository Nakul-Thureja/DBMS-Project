package com.example.bank

import android.R
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement


class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.bank.R.layout.activity_card)
        val CID = intent.getStringExtra("CID")
        val pass = intent.getStringExtra("pass")
        val acc_no = intent.getStringExtra("Acc")
        val cardNo: TextView = findViewById(com.example.bank.R.id.cardNo)
        val validity: TextView = findViewById(com.example.bank.R.id.Validity)
        val card_info: ArrayList<String> = GetTextSQL(CID!!, pass!!, acc_no!!)
        val b: Button = findViewById(com.example.bank.R.id.btn_requestcard)
        val blocker: Button = findViewById(com.example.bank.R.id.btn_block)
        blocker.setOnClickListener {
            BlockCard(CID!!, pass!!, card_info[0])
            blocker.text = "BLOCKED"
        }

        b.setOnClickListener {
            createCard(CID, pass, acc_no)
        }

        if (!card_info.isEmpty()) {
            b.visibility = View.GONE
            cardNo.text = "Card No: ${card_info[0]}"
            validity.text = "Valid till: ${card_info[1]}"
        } else {
            cardNo.text = "Card No: Doesn't exist"
            validity.text = "Valid till: NA"
            blocker.visibility = View.GONE
        }


    }


    fun GetTextSQL(id: String, pass: String, account: String): ArrayList<String> {
        var data = ArrayList<String>()
        try {
            val connectionhelper: ConnectionHelperUser = ConnectionHelperUser()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                val query: String =
                    "Select CardNo,ExpDate from Cards_view where Cards_view.AccNo = $account"
                val st: Statement = connect.createStatement()
                val rs: ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                } else {
                    do {
                        val data1 = rs.getString(1)
                        val data2 = rs.getString(2)
                        data.add(data1)
                        data.add(data2)
                    } while (rs.next())
                }
                return data

            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
        return data
    }

    fun BlockCard(id: String, pass: String, cardNo: String) {
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                val query: String = "Delete from Cards where CardNo = $cardNo"
                val st: Statement = connect.createStatement()
                val rs: Int = st.executeUpdate(query)
            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
    }

    fun createCard(id: String, pass: String, accNo: String) {

        try {
            var counter = 0
            var today = ""
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {

                val query0: String = "SELECT CAST( GETDATE() AS Date )"
                val st0: Statement = connect.createStatement()
                val rs0: ResultSet = st0.executeQuery(query0)
                if (!rs0.next()) {
                    println("ResultSet isss empty in Java")
                } else {
                    do {
                        today = rs0.getString(1);
                    } while (rs0.next())

                    val queryinit: String = "select count(*) from Cards"
                    val stinit: Statement = connect.createStatement()
                    val rsinit: ResultSet = stinit.executeQuery(queryinit)
                    var count = "0";
                    while (rsinit.next()) {
                        count = rsinit.getString(1)
                    }
                    counter = count.toInt()
                    counter++
                    val rnds = (100..999).random()
                    var expyear = today.subSequence(0,4).toString().toInt()
                    expyear += 4
                    val expfinal = expyear.toString()+today.subSequence(4,10)

                    val query: String =
                        "INSERT INTO Cards(CardNo,cvv,AccNo,IssueDATE,ExpDATE,pin) " +
                                "VALUES ($counter,'$rnds',$accNo,'$today','$expfinal',$pass)"
                    val st: Statement = connect.createStatement()
                    val rs: Int = st.executeUpdate(query)
                }
            }

        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
        Toast.makeText(this, "Your Card was Created. Reload to check again", Toast.LENGTH_SHORT).show()
        this.finish()
    }


}