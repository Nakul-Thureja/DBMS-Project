package com.example.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LoanListAdapter(private val items: ArrayList<String>, private val listener: OnItemClickListener):

    RecyclerView.Adapter<LoanListAdapter.LoanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_loan, parent, false)
        return LoanViewHolder(view);
    }

    override fun onBindViewHolder(holder: LoanViewHolder, position: Int) {
        val currentItem = items[position]
        holder.LoanNo.text = "Account No: " + currentItem
    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class LoanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var LoanNo: TextView = itemView.findViewById(R.id.LoanNo)
        var LoanType: TextView = itemView.findViewById(R.id.LoanType)
        var LoanBranch: TextView = itemView.findViewById(R.id.LoanBranch)
        var DOC: TextView = itemView.findViewById(R.id.DOC)
        var Duration: TextView = itemView.findViewById(R.id.Duration)

        var Repay: Button = itemView.findViewById(R.id.btn_repay)
        var Balance: Button = itemView.findViewById(R.id.btn_balance)
        var Passbook: Button = itemView.findViewById(R.id.btn_passbook)

        init {
            Repay.setOnClickListener(this)
            Balance.setOnClickListener(this)
            Passbook.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if(p0?.id == R.id.btn_repay)
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