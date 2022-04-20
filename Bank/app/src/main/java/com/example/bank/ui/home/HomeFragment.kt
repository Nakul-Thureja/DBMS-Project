package com.example.bank.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bank.*
import com.example.bank.databinding.FragmentHomeBinding

class HomeFragment : Fragment(),AccountListAdapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(activity);
        val items = fetchData()

        val adapter: AccountListAdapter = AccountListAdapter(items,this)
        recyclerView.adapter = adapter

        return root
    }

    private fun fetchData(): ArrayList<String> {
        val list = ArrayList<String>()
        for(i in 0 until 100){
            list.add("Account No: $i")
        }
        return list;
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(pos: Int,option : Int) {
        if(option == 1){
            val intent = Intent(activity, CardActivity::class.java);
            intent.putExtra("CardNo",pos)
            startActivity(intent)
        }
        else if(option==2){
            val intent = Intent(activity, SendMoneyActivity::class.java);
            intent.putExtra("CardNo",pos)
            startActivity(intent)
        }
        else if(option==3){
            val intent = Intent(activity, BalanceActivity::class.java);
            intent.putExtra("AccNo",pos)
            startActivity(intent)
        }
        else if(option==4){
            val intent = Intent(activity, AvailActivity::class.java);
            intent.putExtra("CardNo",pos)
            startActivity(intent)
        }
        else if(option==5){
            val intent = Intent(activity, PassbookActivity::class.java);
            intent.putExtra("AccNo",pos)
            startActivity(intent)
        }
    }
}