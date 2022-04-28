package com.example.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bank.ui.mAccounts.MAccountsFragment

class MAccountListAdapter(private val items: ArrayList<Accountdata>, private val listener: MAccountsFragment):
    RecyclerView.Adapter<MAccountListAdapter.MAccountViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MAccountViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.m_item_account, parent, false)
        return MAccountViewHolder(view);
    }

    override fun onBindViewHolder(holder: MAccountViewHolder, position: Int) {
        val currentItem = items[position]
        holder.AccountNo.text = "Account No: " +currentItem.AccNo
        holder.AccountType.text = "Account Type: "+currentItem.AccType
        holder.AccountBranch.text = "Branch No: "+currentItem.BranchNo
    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class MAccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var AccountNo: TextView = itemView.findViewById(R.id.AccountNo)
        var AccountType:TextView= itemView.findViewById(R.id.AccountType)
        var AccountBranch:TextView= itemView.findViewById(R.id.AccountBranch)
        var Card: Button = itemView.findViewById(R.id.btn_card)
        var Balance: Button = itemView.findViewById(R.id.btn_balance)
        var Passbook: Button = itemView.findViewById(R.id.btn_passbook)

        init {
            Card.setOnClickListener(this)
            Balance.setOnClickListener(this)
            Passbook.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if(p0?.id == R.id.btn_card)
                    listener.onItemClick(position,1)
                else if(p0?.id == R.id.btn_balance)
                    listener.onItemClick(position,2)
                else if(p0?.id == R.id.btn_passbook)
                    listener.onItemClick(position,3)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(pos: Int,option : Int)
    }
}