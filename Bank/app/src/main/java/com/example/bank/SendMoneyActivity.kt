package com.example.bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class SendMoneyActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var TransactionType = arrayOf<String?>("Net Banking", "Card")
    var cvv: TextInputLayout? = null
    var type = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money)
        val spinner: Spinner = findViewById(R.id.spinner)
        val CID = intent.getStringExtra("CID")
        val pass = intent.getStringExtra("pass")
        val acc_no = intent.getStringExtra("Acc")
        val et_acc :TextView = findViewById(R.id.et_acc)
        val et_amt : TextView = findViewById(R.id.et_amt)
        val btn_transfer : Button = findViewById(R.id.btn_transfer)
        val et_cvv: TextView = findViewById(R.id.et_cvv)
        btn_transfer.setOnClickListener {
            val amount = et_amt.text.toString()
            var amount2 = GetTextSQL(CID!!,pass!!,amount,acc_no!!)
            amount2 -= amount.toInt()
            if(amount2<0){
                Toast.makeText(this, "Can't deduct more amount than balance", Toast.LENGTH_SHORT).show()
            }
            else {
                updateBalance(CID!!, pass!!,acc_no,et_acc.text.toString(),amount,amount2.toString())
            }
        }
        cvv = findViewById(R.id.cardLayout)
        cvv!!.visibility = View.INVISIBLE

        spinner.onItemSelectedListener = this

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            TransactionType
        )
        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = ad
    }

    override fun onItemSelected(parent: AdapterView<*>?,
                                view: View, position: Int,
                                id: Long) {

        if(TransactionType[position] == "Net Banking"){
            type = "Net Banking"
        }
        else if(TransactionType[position] == "Card"){
            type = "Card"
            cvv!!.visibility = View.VISIBLE
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }


    fun GetTextSQL(id : String, pass : String,amount:String,acc_no:String) :Int{
        var data = ""
        println("hello")
        try {
            val connectionhelper: ConnectionHelperUser = ConnectionHelperUser()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                val query0: String = "Select Balance from Accounts_view where AccNo = $acc_no"
                val st0: Statement = connect.createStatement()
                val rs0: ResultSet = st0.executeQuery(query0)
                if (!rs0.next()) {
                    println("ResultSet in empty in Java")
                } else {
                    do {
                        data = rs0.getString(1)
                    } while (rs0.next())
                }

            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
        return data.toInt()
    }


    fun updateBalance(id : String, pass : String, acc_no: String,recAcc:String,amountcut:String,amount:String) {
        try {
            var today = ""
            var counter = 0
            var samount = 0
            var ramount = 0
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

                    val queryinit: String = "select count(*) from Transactions"
                    val stinit: Statement = connect.createStatement()
                    val rsinit: ResultSet = stinit.executeQuery(queryinit)
                    var count = "0";
                    while (rsinit.next()) {
                        count = rsinit.getString(1)
                    }
                    counter = count.toInt()
                    counter++

                    val querys: String = "select Balance from Accounts where Accno = $acc_no"
                    val sts: Statement = connect.createStatement()
                    val rss: ResultSet = sts.executeQuery(querys)
                    var temp = "0"
                    while (rss.next()) {
                        temp = rss.getString(1)
                    }
                    samount = temp.toInt()
                    samount -= amountcut.toInt()

                    val queryr: String = "select Balance from Accounts where Accno = $recAcc"
                    val str: Statement = connect.createStatement()
                    val rsr: ResultSet = str.executeQuery(queryr)
                    var temp2 = "0";
                    while (rsr.next()) {
                        temp2 = rsr.getString(1)
                    }
                    ramount = temp2.toInt()
                    ramount += amountcut.toInt()

                   val query1: String =
                        "INSERT INTO Transactions (Tno,TransactionType,SenderAccNo,Amount,DOT,ReceiverAccNo) " +
                                "VALUES (10000000$counter,'$type',$acc_no,$amountcut,'$today',$recAcc)"
                    val st1: Statement = connect.createStatement()
                    val rs1: Int = st1.executeUpdate(query1)

                    val query2: String =
                        "Update Accounts set Balance = $samount where AccNo = $acc_no"
                    val st2: Statement = connect.createStatement()
                    val rs2: Int = st2.executeUpdate(query2)

                    val query3: String =
                        "Update Accounts set Balance = $ramount where AccNo = $recAcc"
                    val st3: Statement = connect.createStatement()
                    val rs3: Int = st3.executeUpdate(query3)

                    val query4: String =
                        "Create or Alter View transactions_view as Select * from Transactions where SenderAccNo = $acc_no or ReceiverAccNo = $acc_no"
                    val st4: Statement = connect.createStatement()
                    val rs4: Int = st4.executeUpdate(query4)
                }
            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
        Toast.makeText(this, "The Amount was deducted. Your new balance is $amount", Toast.LENGTH_SHORT).show()
        this.finish()

    }

}