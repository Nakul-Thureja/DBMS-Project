package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class ManagerActivity : AppCompatActivity() {
    var data = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager)
        val btn_log_in = findViewById<Button>(R.id.btn_log_in)
        val et_bid = findViewById<TextView>(R.id.et_bid)
        val et_id = findViewById<TextView>(R.id.et_eid)
        val et_password = findViewById<TextView>(R.id.et_password)

        btn_log_in.setOnClickListener {
            if(et_id.text.isEmpty()){
                Toast.makeText(this, "please enter your Employee ID", Toast.LENGTH_SHORT).show()
            }
            else if(et_password.text.isEmpty()){
                Toast.makeText(this, "please enter your Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val name = et_id.text.toString()
                val pass = et_password.text.toString()
                val branch  = et_bid.text.toString()
                if(GetTextSQL(name,pass,branch)) {
                    val intent = Intent(this, Main4Activity::class.java);
                    intent.putExtra("ID",data);
                    intent.putExtra("password",pass)
                    intent.putExtra("branch",branch)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "The Username or Password is incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    fun GetTextSQL(id : String, pass : String,branch:String) : Boolean {
        try{
            val connectionhelper : ConnectionHelper = ConnectionHelper()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query: String = "Select ManagerID from Branch,Employee where Branch.Branchno = $branch and Branch.ManagerID = $id and Employee.Password = $pass and Employee.empID = Branch.managerID ";
                val st: Statement = connect.createStatement()
                val rs: ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet isss empty in Java")
                    return false
                } else {
                    do {
                        data = rs.getString(1);
                        granter(connect,data,branch)
                        return true
                    } while (rs.next())
                }

            }
            connect.close()
        }
        catch (e:Exception){
            Log.e("Errorss", e.message!!)
        }
        return false
    }

    fun granter(connect : Connection, id:String,branch:String){
        if(connect!=null){

            val query2 = "Create or Alter View manager_accounts_view as Select * from Accounts where branchno = $branch"
            val st2: Statement = connect.createStatement()
            val rs2: Int = st2.executeUpdate(query2)

            val query1 = "Create or Alter View manager_Customer_view as Select * from Customer where CID in (Select CID from manager_accounts_view)"
            val st1: Statement = connect.createStatement()
            val rs1: Int = st1.executeUpdate(query1)


            val query02 = "Create or Alter View manager_cards_view as Select * from Cards where Accno in (Select Accno from manager_accounts_view)"
            val st02: Statement = connect.createStatement()
            val rs02: Int = st02.executeUpdate(query02)

            val query12 = "Create or Alter View manager_transactions_view as Select * from Transactions where SenderAccNo in (Select Accno from manager_accounts_view) or ReceiverAccNo in (Select Accno from manager_accounts_view)"
            val st12: Statement = connect.createStatement()
            val rs12: Int = st12.executeUpdate(query12)

            val query22 = "Create or Alter View manager_loan_view as Select * from Loan where branchno = $branch"
            val st22: Statement = connect.createStatement()
            val rs22: Int = st12.executeUpdate(query22)

            val query32 = "Create or Alter View manager_employee_view as Select * from Employee where Empid in (Select EmpId from Works where branchNo = $branch)"
            val st32: Statement = connect.createStatement()
            val rs32: Int = st32.executeUpdate(query32)

            val query52 = "Create or Alter View manager_works_view as Select * from Works where branchNo = $branch"
            val st52: Statement = connect.createStatement()
            val rs52: Int = st52.executeUpdate(query52)


            val query42 = "Create or Alter View manager_branch_view as Select * from Branch where BranchNo = $branch"
            val st42: Statement = connect.createStatement()
            val rs42: Int = st42.executeUpdate(query42)

            val query3 = "Grant Select,Update on manager_Customer_view to M$id"
            val st3: Statement = connect.createStatement()
            val rs3: Int = st3.executeUpdate(query3)

            val query4 = "Grant Select,Update on manager_Accounts_view to M$id"
            val st4: Statement = connect.createStatement()
            val rs4: Int = st4.executeUpdate(query4)

            val query5 = "Grant Select,Update on manager_Cards_view to M$id"
            val st5: Statement = connect.createStatement()
            val rs5: Int = st5.executeUpdate(query5)

            val query6 = "Grant Select,Update on manager_transactions_view to M$id"
            val st6: Statement = connect.createStatement()
            val rs6 : Int = st6.executeUpdate(query6)

            val query7 = "Grant Select,Update on manager_loan_view to M$id"
            val st7: Statement = connect.createStatement()
            val rs7 : Int = st7.executeUpdate(query7)

            val query8 = "Grant Select,Update on manager_employee_view to M$id"
            val st8: Statement = connect.createStatement()
            val rs8 : Int = st8.executeUpdate(query8)

            val query9 = "Grant Select,Update on manager_branch_view to M$id"
            val st9: Statement = connect.createStatement()
            val rs9 : Int = st9.executeUpdate(query9)

            val query10 = "Grant Select,Update on manager_works_view to M$id"
            val st10: Statement = connect.createStatement()
            val rs10 : Int = st10.executeUpdate(query10)


        }
    }
        }
