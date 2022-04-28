package com.example.bank.ui.mAccounts

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
import com.example.bank.databinding.FragmentMaccountsBinding
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class MAccountsFragment : Fragment() {
    var myID = ""
    var myPass = ""
    var myBranch = ""
    private var _binding: FragmentMaccountsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    var items = ArrayList<Accountdata>()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(MAccountsViewModel::class.java)
        val activity: Main4Activity = getActivity() as Main4Activity
        myID = activity.getMyID().toString()
        myPass = activity.getMyPass().toString()
        myBranch = activity.getMyBranch().toString()

        _binding = FragmentMaccountsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        items = GetTextSQL(myID, myPass,myBranch)

        val recyclerView: RecyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(activity);

        val adapter: MAccountListAdapter = MAccountListAdapter(items, this)
        recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun GetTextSQL(id: String, pass: String,branch:String): ArrayList<Accountdata> {
        val send = ArrayList<Accountdata>()
        try {
            val connectionhelper: ConnectionHelperManager = ConnectionHelperManager()
            val connect: Connection = connectionhelper.connectionclass(id, pass)
            if (connect != null) {
                val query: String =
                    "Select AccNo,AccType,BranchNo from manager_accounts_view"
                val st: Statement = connect.createStatement()
                val rs: ResultSet = st.executeQuery(query)
                if (!rs.next()) {
                    println("ResultSet in empty in Java")
                } else {
                    do {
                        val data = rs.getString(1)
                        val data2 = rs.getString(2)
                        val data3 = rs.getString(3)
                        val acc = Accountdata(data, data2, data3)
                        send.add(acc)
                    } while (rs.next())
                }
                return send

            }
        } catch (e: Exception) {
            Log.e("Errorss", e.message!!)
        }
        return send
    }

    fun onItemClick(pos: Int, option: Int) {
        if (option == 1) {
            val intent = Intent(activity, MCardActivity::class.java);
            intent.putExtra("CardNo", pos)
            intent.putExtra("ID", myID)
            intent.putExtra("pass", myPass)
            intent.putExtra("Acc", items[pos].AccNo)
            startActivity(intent)
        } else if (option == 2) {
            val intent = Intent(activity, MBalanceActivity::class.java);
            intent.putExtra("CardNo", pos)
            intent.putExtra("ID", myID)
            intent.putExtra("pass", myPass)
            intent.putExtra("Acc", items[pos].AccNo)
            startActivity(intent)
        } else if (option == 3) {
            val intent = Intent(activity, MPassbookActivity::class.java);
            intent.putExtra("AccNo", pos)
            intent.putExtra("ID", myID)
            intent.putExtra("pass", myPass)
            intent.putExtra("Acc", items[pos].AccNo.toString())
            startActivity(intent)
        }


    }


}