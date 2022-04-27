package com.example.bank

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.bank.databinding.ActivityMain2Binding
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class AccountScreen1 : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding

    var CID = String()
    var Pass = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        val extras = intent.extras
        if (extras != null) {
            CID = extras.getString("CID").toString()
            Pass = extras.getString("password").toString()
            granter(CID,Pass)

        }

        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarAccountScreen1.toolbar)

        binding.appBarAccountScreen1.fab.setOnClickListener { view ->
            val intent = Intent(this, SignUp3::class.java);
            intent.putExtra("CID",CID)
            startActivity(intent)
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_account_screen1)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_account, R.id.nav_loan, R.id.nav_contact_us
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.account_screen1, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_account_screen1)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun getMyCID(): String? {
        return CID
    }

    fun getMyPass() :String?{
        return Pass
    }
    fun granter(id: String,pass:String) {
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                val query1 =
                    "Create or Alter View customer_view as Select * from Customer where CID = $id"
                val st1: Statement = connect.createStatement()
                val rs1: Int = st1.executeUpdate(query1)

                val query2 =
                    "Create or Alter View accounts_view as Select * from Accounts where CID = $id"
                val st2: Statement = connect.createStatement()
                val rs2: Int = st2.executeUpdate(query2)

                var acc_no = ""
                val query0 = "Select AccNo from accounts_view"
                val st0: Statement = connect.createStatement()
                val rs0: ResultSet = st0.executeQuery(query0)
                if (!rs0.next()) {
                    println("ResultSet in empty in Java")
                } else {
                    do {
                        acc_no = rs0.getString(1)
                    } while (rs0.next())
                }

                val query02 =
                    "Create or Alter View cards_view as Select * from Cards where AccNo = $acc_no"
                val st02: Statement = connect.createStatement()
                val rs02: Int = st02.executeUpdate(query02)

                val query12 =
                    "Create or Alter View transactions_view as Select * from Transactions where SenderAccNo = $acc_no or ReceiverAccNo = $acc_no"
                val st12: Statement = connect.createStatement()
                val rs12: Int = st12.executeUpdate(query12)

                val query3 = "Grant Select on Customer_view to U$id"
                val st3: Statement = connect.createStatement()
                val rs3: Int = st3.executeUpdate(query3)

                val query4 = "Grant Select on Accounts_view to U$id"
                val st4: Statement = connect.createStatement()
                val rs4: Int = st4.executeUpdate(query4)

                val query5 = "Grant Select on Cards_view to U$id"
                val st5: Statement = connect.createStatement()
                val rs5: Int = st5.executeUpdate(query5)

                val query6 = "Grant Select on transactions_view to U$id"
                val st6: Statement = connect.createStatement()
                val rs6: Int = st6.executeUpdate(query6)
            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
    }

}