package com.example.bank.ui.mLoan

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bank.*
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class MLoanFragment : Fragment() ,MLoanListAdapter.OnItemClickListener {

    private var _binding: com.example.bank.databinding.FragmentMloanBinding? = null
    var myID = ""
    var myPass = ""
    var myBranch = ""
    // This property is only valid between onCreateView and
    // onDestroyView.

    var items = ArrayList<MLoanAccountData>()
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
            ViewModelProvider(this).get(MLoanViewModel::class.java)

        _binding = com.example.bank.databinding.FragmentMloanBinding.inflate(inflater, container, false)
        val root= binding.root

        val recyclerView: RecyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(activity);
        items = GetTextSQL(myID, myPass,myBranch)

        val adapter: MLoanListAdapter = MLoanListAdapter(items,this)
        recyclerView.adapter = adapter


        return root

    }


    private fun GetTextSQL(id : String, pass : String, branch :String) : ArrayList<MLoanAccountData> {
        val send = ArrayList<MLoanAccountData>()
        try{
            val connectionhelper : ConnectionHelperManager = ConnectionHelperManager()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query : String = "Select LoanID,LoanType,BranchNo,DOC,Duration,Status,TotalAmount,RemainingAmount from manager_Loan_view "
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
                        val data5 = rs.getString(5)
                        val data6 = rs.getString(6)
                        val data7 = rs.getString(7)
                        val data8 = rs.getString(8)
                        val acc = MLoanAccountData(data,data2,data3,data4,data5,data6,data7,data8)
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
        if(option==-1){
            Toast.makeText(activity,"SHEESH", Toast.LENGTH_SHORT).show()
        }
        if(option == 1){
            loan_permitter(myID,myPass,items[pos].number,1)
            Toast.makeText(activity,"Loan Approved",Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, Main4Activity::class.java)
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }

        else if(option==2){
            loan_permitter(myID,myPass,items[pos].number,0)
            Toast.makeText(activity,"Loan Denied",Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, Main4Activity::class.java)
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)

        }

    }

    fun loan_permitter(id: String, pass: String, acc_no: String, t:Int) {
        try {
            val connectionhelper: ConnectionHelperManager = ConnectionHelperManager()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                var query = ""
                if(t==0){
                    query = "Update manager_Loan_view set Status = 'Not-Approved' where LoanID = $acc_no"
                }
                else{
                    query = "Update manager_Loan_view set Status = 'Approved' where LoanID = $acc_no"
                }

                val st: Statement = connect.createStatement()
                val rs: Int = st.executeUpdate(query)
            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
    }
}