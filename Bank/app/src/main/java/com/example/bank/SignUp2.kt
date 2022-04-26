package com.example.bank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class SignUp2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)
        val next: Button = findViewById(R.id.btn_next)

        val et_name = intent.getStringExtra("Name")
        val et_phone = intent.getStringExtra("Phone")
        val et_email = intent.getStringExtra("Email")
        val et_dob = intent.getStringExtra("Dob")
        val et_gender = intent.getStringExtra("Gender")

        val et_address = findViewById<TextView>(R.id.et_address)
        val et_aadhar = findViewById<TextView>(R.id.et_aadhar)
        val et_pan = findViewById<TextView>(R.id.et_pan)
        val et_password = findViewById<TextView>(R.id.et_password)
        val et_re_password = findViewById<TextView>(R.id.et_re_password)
        next.setOnClickListener {
            if (et_password.text.toString() != et_re_password.text.toString()) {
                Toast.makeText(this, "The passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                val CID  = GetTextSQL(et_name!!, et_phone!!,et_email!!,et_dob!!,et_address.text.toString()
                    ,et_aadhar.text.toString()
                    ,et_pan.text.toString()
                    ,et_password.text.toString()
                ,et_gender!!)
                nextPage(it,CID)
            }
        }
    }


    fun nextPage(it: View,CID:String) {
        val intent = Intent(this,SignUp3::class.java)
        intent.putExtra("CID",CID)
        startActivity(intent)
    }

    fun GetTextSQL(name : String,phone:String,email : String,dob:String,address:String,aadhar:String,pan:String,password:String, gender:String) : String{
        var counter = 0;
        try{
            val connectionhelper : ConnectionHelper = ConnectionHelper()
            val connect : Connection = connectionhelper.connectionclass("random","random")
            if(connect!=null) {
                val queryinit: String = "select count(*) from Customer"
                val stinit: Statement = connect.createStatement()
                val rsinit: ResultSet = stinit.executeQuery(queryinit)
                var count = "0";
                while (rsinit.next()) {
                    count = rsinit.getString(1)
                }
                counter = count.toInt()
                counter++
                println(counter)
                val query: String =
                    "INSERT INTO Customer(CID,Pass,AadharNo,PanNo,Name,DOB,Address,PhoneNo,Email,Gender) VALUES" +
                            "(1000000$counter,$password,$aadhar,$pan,'$name','$dob','$address',$phone,'$email','$gender') "
                val st: Statement = connect.createStatement()
                val rs: Int = st.executeUpdate(query)

                connect.close()
            }
        }
        catch (e:Exception){
            Log.e("Errorss", e.message!!)
        }
        return "1000000$counter"
    }
}