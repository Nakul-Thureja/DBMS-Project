package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresPermission
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class SignIn : AppCompatActivity() {
    var data = String()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val btn_log_in = findViewById<Button>(R.id.btn_log_in)
        val et_id = findViewById<TextView>(R.id.et_id)
        val et_password = findViewById<TextView>(R.id.et_password)

        btn_log_in.setOnClickListener{
            if(et_id.text.isEmpty()){
                Toast.makeText(this, "please enter your Customer ID", Toast.LENGTH_SHORT).show()
            }
            else if(et_password.text.isEmpty()){
                Toast.makeText(this, "please enter your Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val name = et_id.text.toString()
                val pass = et_password.text.toString()
                if(GetTextSQL(name,pass)) {
                    val intent = Intent(this, AccountScreen1::class.java);
                    intent.putExtra("CID",data);
                    intent.putExtra("password",pass)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "The Username or Password is incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


     fun GetTextSQL(id : String, pass : String) : Boolean {
        try{
            val connectionhelper : ConnectionHelper = ConnectionHelper()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query : String = "Select CID from Customer where CID = $id and Pass = $pass";
                val st : Statement = connect.createStatement()
                val rs : ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                    return false
                }
                else {
                    do {
                        data = rs.getString(1);

                        return true
                    } while (rs.next()) }

            }
            connect.close()

        }
        catch (e:Exception){
            Log.e("Errorss", e.message!!)
        }
        return false
    }

}