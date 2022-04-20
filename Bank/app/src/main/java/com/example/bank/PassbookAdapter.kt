package com.example.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PassbookAdapter (private val items: ArrayList<String>):
    RecyclerView.Adapter<PassbookAdapter.PassbookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassbookViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return PassbookViewHolder(view);
    }

    override fun onBindViewHolder(holder: PassbookAdapter.PassbookViewHolder, position: Int) {
        val currentItem = items[position]
        holder.TransNo.text = currentItem
    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class PassbookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var TransNo: TextView = itemView.findViewById(R.id.TransNo)
    }
}