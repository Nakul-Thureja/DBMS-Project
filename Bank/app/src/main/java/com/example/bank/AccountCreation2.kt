package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class AccountCreation2 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var branchd = getBranches()
    var i =0;
    var branches = Array<String>(branchd.size,{i-> "0"})
    var  branch_num = 0
    var  loan_type = ""

    var loanType = arrayOf<String?>(
        "Home","Car","Personal"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creation2)

        val btn_acc : Button = findViewById(R.id.btn_start)
        val spinner: Spinner = findViewById(R.id.spinner)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val id = intent.getStringExtra("CID")
        val amount = findViewById<TextView>(R.id.et_amount)
        val duration = findViewById<TextView>(R.id.et_duration)
        val nominee = findViewById<TextView>(R.id.et_nominee)
        do {
            branches[i] = branchd[i].BranchNo + " - " + branchd[i].Address
            i++
        } while (i<branchd.size)

        spinner.onItemSelectedListener = this

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            branches
        )

        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner.adapter = ad
        val ad2: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            loanType
        )

        ad2.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner2.adapter = ad2

        btn_acc.setOnClickListener {
            branch_num = spinner.selectedItemPosition +1
            loan_type = loanType[spinner2.selectedItemPosition].toString()
            GetTextSQL(id!!,"random",amount.text.toString(),nominee.text.toString(),duration.text.toString())
            Toast.makeText(this,"Account Created Successfully",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun GetTextSQL(id : String, pass : String,amount:String,nominee:String,duration:String) {
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
                        today = rs0.getString(1)
                    } while (rs0.next())

                    val queryinit: String = "Select Count(*) from Loan"
                    val stinit: Statement = connect.createStatement()
                    val rsinit: ResultSet = stinit.executeQuery(queryinit)
                    var count = "0"
                    while (rsinit.next()) {
                        count = rsinit.getString(1)
                    }
                    counter = count.toInt()
                    counter++
                    print(counter)
                    val query :String = "INSERT INTO Loan(LoanID,CID,BranchNo,LoanType,duration,DOC,TotalAmount,RemainingAmount,Status,NomineeID) VALUES (10000000000$counter, $id, $branch_num, '$loan_type', $duration, '$today', $amount, $amount, 'Pending', $nominee)"
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

    }
    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}