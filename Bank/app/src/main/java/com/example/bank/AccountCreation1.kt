package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import org.w3c.dom.Text
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class AccountCreation1 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
        private var branchd = getBranches()
    var i =0;
        var branches = Array<String>(branchd.size,{i-> "0"})
    var  branch_num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation1)
        val tvAccType: TextView = findViewById(R.id.accType)
        val spinner: Spinner = findViewById(R.id.spinner)
        val btn_acc: Button = findViewById(R.id.btn_acc)

        do {
            branches[i] = branchd[i].BranchNo + " - " + branchd[i].Address
            i++
        } while (i<branchd.size)

        spinner.onItemSelectedListener = this
        val type = intent.getStringExtra("type");
        val id = intent.getStringExtra("CID")
        val amount :TextView = findViewById<TextView>(R.id.et_amount)
        val nominee : TextView = findViewById<TextView>(R.id.et_nominee)
        tvAccType.setText(type)
        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            branches
        )
        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = ad
        btn_acc.setOnClickListener {
            GetTextSQL(id!!,"random",type!!,amount.text.toString(),nominee.text.toString())
            Toast.makeText(this,"Account Created Successfully",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java);
            startActivity(intent)
        }


    }



    fun GetTextSQL(id : String, pass : String,type:String,amount:String,nominee:String) {
       var today = String()
        var counter = 0
        try{
            val connectionhelper : ConnectionHelper = ConnectionHelper()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query0 : String = "SELECT CAST( GETDATE() AS Date )"
                val st0 : Statement = connect.createStatement()
                val rs0 : ResultSet = st0.executeQuery(query0)
                if (!rs0.next()) {
                    println("ResultSet isss empty in Java")
                } else {
                    do {
                        today = rs0.getString(1);
                    } while (rs0.next())

                    val queryinit: String = "select count(*) from Accounts"
                    val stinit: Statement = connect.createStatement()
                    val rsinit: ResultSet = stinit.executeQuery(queryinit)
                    var count = "0";
                    while (rsinit.next()) {
                        count = rsinit.getString(1)
                    }
                    counter = count.toInt()
                    counter++
                    println(counter)
                    println(id)
                    println(branch_num)
                    println(type)
                    println(amount)
                    println(today)
                    println(nominee)
                    val query :String = "INSERT INTO Accounts(AccNo, CID, BranchNo, AccType, Balance, DOC, InterestAmount, NomineeID) VALUES (100000000000$counter, $id, $branch_num, '$type', $amount, '$today', 0, $nominee)"
                    val st: Statement = connect.createStatement()
                    val rs: Int = st.executeUpdate(query)

                }

            }
            connect.close()
        }
        catch (e:Exception){
            Log.e("Errorss", e.message!!)
        }
    }

    fun getBranches() :ArrayList<BranchData>{
        var branch = ArrayList<BranchData>()
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass("random", "random")
            if (connect != null) {
                val query0: String = "SELECT BranchNo,Address FROM Branch"
                val st0: Statement = connect.createStatement()
                val rs0: ResultSet = st0.executeQuery(query0)
                if (!rs0.next()) {
                    println("ResultSet isss empty in Java")
                } else {
                    do {
                        val branch1 = rs0.getString(1)
                        val branch2 = rs0.getString(2)
                        branch.add(BranchData(branch1,branch2))
                    } while (rs0.next())
                }
            }
        }catch (e:Exception){
            Log.e("Errorss", e.message!!)
        }
        return branch
    }



    override fun onItemSelected(parent: AdapterView<*>?,
                                view: View, position: Int,
                                id: Long) {

        branch_num = position+1
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}