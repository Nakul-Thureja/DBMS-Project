package com.example.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AccountListAdapter(private val items: ArrayList<String>):
    RecyclerView.Adapter<AccountViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_account,parent,false)
        return AccountViewHolder(view);
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int){
        val currentItem = items[position]
        holder.AccountNo.text = currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }


}

class AccountViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var AccountNo: TextView = itemView.findViewById(R.id.AccountNo)
 }