package com.example.bank

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.RecyclerView

class AccountListAdapter(private val items: ArrayList<String>,private val listener: OnItemClickListener):
    RecyclerView.Adapter<AccountListAdapter.AccountViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent, false)
        return AccountViewHolder(view);
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val currentItem = items[position]
        holder.AccountNo.text = currentItem
    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var AccountNo: TextView = itemView.findViewById(R.id.AccountNo)
        var Card: Button = itemView.findViewById(R.id.btn_card)
        var Transfer: Button = itemView.findViewById(R.id.btn_transfer)
        var Balance: Button = itemView.findViewById(R.id.btn_balance)
        var Avail: Button = itemView.findViewById(R.id.btn_avail)
        var Passbook: Button = itemView.findViewById(R.id.btn_passbook)

        init {
            Card.setOnClickListener(this)
            Transfer.setOnClickListener(this)
            Balance.setOnClickListener(this)
            Avail.setOnClickListener(this)
            Passbook.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if(p0?.id == R.id.btn_card)
                    listener.onItemClick(position,1)
                else if(p0?.id == R.id.btn_transfer)
                    listener.onItemClick(position,2)
                else if(p0?.id == R.id.btn_balance)
                    listener.onItemClick(position,3)
                else if(p0?.id == R.id.btn_avail)
                    listener.onItemClick(position,4)
                else if(p0?.id == R.id.btn_passbook)
                    listener.onItemClick(position,5)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(pos: Int,option : Int)
    }
}