package com.example.bank
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.bank.databinding.ActivityMain32Binding
import org.w3c.dom.Text
import java.lang.Exception
import java.sql.Connection
import java.sql.Statement

class Main4Activity : AppCompatActivity() {
    var ID = String()
    var Pass = String()
    var Branch = String()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain32Binding
//    val name: TextView = findViewById<TextView>(R.id.namer)
//    val cid_input : TextView = findViewById<TextView>(R.id.customerID)

    override fun onCreate(savedInstanceState: Bundle?) {
        val extras = intent.extras
        if (extras != null) {
            ID = extras.getString("ID").toString()
            Pass = extras.getString("password").toString()
            Branch =extras.getString("branch").toString()
            granter(ID,Pass,Branch)

        }
        super.onCreate(savedInstanceState)

     binding = ActivityMain32Binding.inflate(layoutInflater)
     setContentView(binding.root)

        setSupportActionBar(binding.appBarMain32.toolbar)

//        binding.appBarMain32.fab.setOnClickListener {
//            name.text = "MENU"
//            cid_input.text="Welcome"
//
//        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main32)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_maccount, R.id.nav_mloan, R.id.nav_employee), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_settings) {
            this.finish()
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main4, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main32)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    fun getMyID(): String? {
        return ID
    }

    fun getMyPass() :String?{
        return Pass
    }

    fun getMyBranch() :String?{
        return Branch

    }    }
    fun granter(id: String,pass:String,branch:String) {
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
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
        catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
}