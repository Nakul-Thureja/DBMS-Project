package com.example.bank.ui.Employee

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bank.*
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class EmployeeFragment : Fragment() , EmployeeListAdapter.OnItemClickListener {

    private var _binding: com.example.bank.databinding.FragmentEmployeeBinding? = null
    var myID = ""
    var myPass = ""
    var myBranch = ""
    // This property is only valid between onCreateView and
    // onDestroyView.
    var items = ArrayList<EmployeeData>()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val activity : Main4Activity = getActivity() as Main4Activity
        myID = activity.getMyID().toString()
        myPass = activity.getMyPass().toString()
        myBranch = activity.getMyBranch().toString()


        val homeViewModel =
            ViewModelProvider(this).get(EmployeeViewModel::class.java)

        _binding = com.example.bank.databinding.FragmentEmployeeBinding.inflate(inflater, container, false)
        val root= binding.root

        val recyclerView: RecyclerView = binding.recyclerView
        val btn_reward: Button = binding.btnReward

        btn_reward.setOnClickListener {
            rewarder(myID,myPass)
            Toast.makeText(activity,"5% Raises Given",Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, Main4Activity::class.java)
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(activity);
        items = GetTextSQL(myID, myPass,myBranch)

        val adapter: EmployeeListAdapter = EmployeeListAdapter(items,this)
        recyclerView.adapter = adapter

        return root

    }


    private fun GetTextSQL(id : String, pass : String,branch:String) : ArrayList<EmployeeData> {
        val send = ArrayList<EmployeeData>()
        try{
            val connectionhelper : ConnectionHelperManager = ConnectionHelperManager()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query : String = "Select EmpID,Name,PhoneNo,Salary from manager_employee_view"
                val st : Statement = connect.createStatement()
                val rs : ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                }
                else {
                    do {
                        val data = rs.getString(1)
                        val data2 = rs.getString(2)
                        val data3 = rs.getString(3)
                        val data4 = rs.getString(4)
                        val acc = EmployeeData(data,data2,data3,data4)
                        send.add(acc)
                    } while (rs.next()) }
                return send

            }
        }
        catch (e:Exception){
            Log.e("Errorss", e.message!!)
        }
        return send
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(pos: Int,option : Int) {
        if(option == 1){
            terminator(myID,myPass,items[pos].EmpID)
            Toast.makeText(activity,"Employee Terminated",Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, Main4Activity::class.java)
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }

        else if(option==2){
            //change
            val intent = Intent(activity, SalaryChange::class.java);
            intent.putExtra("ID", myID)
            intent.putExtra("pass", myPass)
            intent.putExtra("EmpID", items[pos].EmpID)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }

    }

    fun terminator(id: String, pass: String,empID:String) {
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                val query = "Delete from Works where empID = $empID and Empid not in (Select ManagerID from Branch)"
                val st: Statement = connect.createStatement()
                val rs: Int = st.executeUpdate(query)
            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
    }

    fun rewarder(id: String, pass: String) {
        try {
            val connectionhelper: ConnectionHelper = ConnectionHelper()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {

               val query = "Update manager_employee_view SET salary = 1.05*salary"
                        val st: Statement = connect.createStatement()
                        val rs: Int = st.executeUpdate(query)

            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
    }
}