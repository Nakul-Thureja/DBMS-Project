package com.example.bank.ui.Accounts

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
import com.example.bank.databinding.FragmentAccountsBinding
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class AccountsFragment : Fragment() , AccountListAdapter.OnItemClickListener {

    private var _binding: FragmentAccountsBinding? = null
    var myCID =""
    var myPass = ""
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var items = ArrayList<Accountdata>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val activity : AccountScreen1 = getActivity() as AccountScreen1
        myCID = activity.getMyCID().toString()
        myPass = activity.getMyPass().toString()

        val homeViewModel =
            ViewModelProvider(this).get(AccountsViewModel::class.java)

        _binding = FragmentAccountsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(activity);
        items = GetTextSQL(myCID,myPass)

        val adapter: AccountListAdapter = AccountListAdapter(items,this)
        recyclerView.adapter = adapter

        return root
    }


    private fun GetTextSQL(id : String, pass : String) : ArrayList<Accountdata> {
        val send = ArrayList<Accountdata>()
        try{
            val connectionhelper : ConnectionHelperUser = ConnectionHelperUser()
            val connect : Connection = connectionhelper.connectionclass(id,pass)
            if(connect!=null) {
                val query : String = "Select AccNo,AccType,BranchNo from Customer_view,Accounts_view where Accounts_view.CID = $id and Customer_view.CID = Accounts_view.CID"
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
                        val acc = Accountdata(data,data2,data3)
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
            intent.putExtra("CID",myCID)
            intent.putExtra("pass",myPass)
            intent.putExtra("Acc",items[pos].AccNo)
            startActivity(intent)
        }
        else if(option==2){
            val intent = Intent(activity, SendMoneyActivity::class.java);
            intent.putExtra("CardNo",pos)
            intent.putExtra("CID",myCID)
            intent.putExtra("pass",myPass)
            intent.putExtra("Acc",items[pos].AccNo)
            startActivity(intent)
        }
        else if(option==3){
            val intent = Intent(activity, BalanceActivity::class.java);
            intent.putExtra("AccNo",pos)
            intent.putExtra("CID",myCID)
            intent.putExtra("pass",myPass)
            intent.putExtra("Acc",items[pos].AccNo.toString())
            startActivity(intent)
        }
        else if(option==4){
            val intent = Intent(activity, AvailActivity::class.java);
            intent.putExtra("CardNo",pos)
            intent.putExtra("CID",myCID)
            intent.putExtra("pass",myPass)
            intent.putExtra("Acc",items[pos].AccNo)
            startActivity(intent)
        }
        else if(option==5){
            val intent = Intent(activity, PassbookActivity::class.java);
            intent.putExtra("AccNo",pos)
            intent.putExtra("CID",myCID)
            intent.putExtra("pass",myPass)
            intent.putExtra("Acc",items[pos].AccNo)
            startActivity(intent)
        }
    }
}