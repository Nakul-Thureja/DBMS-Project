package com.example.bank.ui.Loan

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bank.*
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class LoanFragment : Fragment() , LoanListAdapter.OnItemClickListener {

    private var _binding: com.example.bank.databinding.FragmentLoanBinding? = null
    var myCID = ""
    var myPass = ""
    // This property is only valid between onCreateView and
    // onDestroyView.
    var items = ArrayList<LoanAccountdata>()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val activity : AccountScreen1 = getActivity() as AccountScreen1
        val myCID = activity.getMyCID().toString()
        val myPass = activity.getMyPass().toString()

        val homeViewModel =
            ViewModelProvider(this).get(LoanViewModel::class.java)

        _binding = com.example.bank.databinding.FragmentLoanBinding.inflate(inflater, container, false)
        val root= binding.root

        val recyclerView: RecyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(activity);
        items = GetTextSQL(myCID, myPass)

        val adapter: LoanListAdapter = LoanListAdapter(items,this)
        recyclerView.adapter = adapter

        return root

    }


    private fun GetTextSQL(id : String, pass : String) : ArrayList<LoanAccountdata> {
        val send = ArrayList<LoanAccountdata>()
        try{
            val connectionhelper : ConnectionHelperUser = ConnectionHelperUser()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query : String = "Select LoanID,LoanType,BranchNo,DOC,Duration from Customer_view,Loan_view where Loan_view.CID = $id and Customer_view.CID = Loan_view.CID"
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
                        val acc = LoanAccountdata(data,data2,data3,data4,data5)
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
            val intent = Intent(activity, CardActivity::class.java);
            intent.putExtra("CardNo",pos)
            intent.putExtra("CID", myCID)
            intent.putExtra("pass", myPass)
            intent.putExtra("Acc", items[pos].number)
            startActivity(intent)
        }
        else if(option==2){
            val intent = Intent(activity, SendMoneyActivity::class.java);
            intent.putExtra("CardNo",pos)
            intent.putExtra("CID", myCID)
            intent.putExtra("pass", myPass)
            intent.putExtra("Acc", items[pos].number)
            startActivity(intent)
        }
        else if(option==3){
            val intent = Intent(activity, BalanceActivity::class.java);
            intent.putExtra("AccNo",pos)
            intent.putExtra("CardNo",pos)
            intent.putExtra("CID", myCID)
            intent.putExtra("pass", myPass)
            intent.putExtra("Acc", items[pos].number)
            startActivity(intent)
        }
        else if(option==4){
            val intent = Intent(activity, AvailActivity::class.java);
            intent.putExtra("CardNo",pos)
            intent.putExtra("CardNo",pos)
            intent.putExtra("CID", myCID)
            intent.putExtra("pass", myPass)
            intent.putExtra("Acc", items[pos].number)
            startActivity(intent)
        }
        else if(option==5){
            val intent = Intent(activity, PassbookActivity::class.java);
            intent.putExtra("AccNo",pos)
            intent.putExtra("CardNo",pos)
            intent.putExtra("CID", myCID)
            intent.putExtra("pass", myPass)
            intent.putExtra("Acc", items[pos].number)
            startActivity(intent)
        }
    }
}