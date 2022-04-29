package com.example.bank.ui.Stats

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.bank.*
import com.example.bank.databinding.FragmentStatsBinding

class StatsFragment : Fragment() {

    private var _binding: FragmentStatsBinding? = null
    var myID = ""
    var myPass = ""
    var myBranch = ""
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contactusViewModel =
            ViewModelProvider(this).get(StatsViewModel::class.java)
        val activity : Main4Activity = getActivity() as Main4Activity

        myID = activity.getMyID().toString()
        myPass = activity.getMyPass().toString()
        myBranch = activity.getMyBranch().toString()

        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        val btn1: Button = binding.btn1
        val btn2: Button = binding.btn2
        val btn3: Button = binding.btn3
        val btn4: Button = binding.btn4
        val btn5: Button = binding.btn5
        val btn6: Button = binding.btn6
        val btn7: Button = binding.btn7

        btn1.setOnClickListener {
            val intent = Intent(activity, StatsActivity1::class.java);
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(activity, StatsActivity2::class.java);
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val intent = Intent(activity, StatsActivity3::class.java);
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }
        btn4.setOnClickListener {
            val intent = Intent(activity, StatsActivity4::class.java);
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }
        btn5.setOnClickListener {
            val intent = Intent(activity, StatsActivity5::class.java);
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }
        btn6.setOnClickListener {
            val intent = Intent(activity, StatsActivity6::class.java);
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }
        btn7.setOnClickListener {
            val intent = Intent(activity, StatsActivity7::class.java);
            intent.putExtra("ID",myID);
            intent.putExtra("password",myPass)
            intent.putExtra("branch",myBranch)
            startActivity(intent)
        }

        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}