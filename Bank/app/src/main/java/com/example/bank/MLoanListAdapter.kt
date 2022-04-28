package com.example.bank

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MLoanListAdapter(private val items: ArrayList<MLoanAccountData>, private val listener: OnItemClickListener):
    RecyclerView.Adapter<MLoanListAdapter.MLoanViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MLoanViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(com.example.bank.R.layout.m_item_loan, parent, false)
        return MLoanViewHolder(view);
    }

    override fun onBindViewHolder(holder: MLoanViewHolder, position: Int) {
        val currentItem = items[position]
        holder.LoanNo.text = "Account No: " + currentItem.number
        holder.LoanType.text = "Loan Type: "+currentItem.type
        holder.LoanBranch.text = "Branch No: "+currentItem.branchnum
        holder.DOC.text = "Date of Creation: "+currentItem.date
        holder.Duration.text = "Duration: "+currentItem.duration
        holder.Status.text = "Status: "+currentItem.status
        holder.Amount.text = "Amount: "+currentItem.amount
        holder.RemainingAmount.text = "Remaining Amount: " + currentItem.remainingamount
        if(!currentItem.status.equals("Pending")) {
            holder.Approve.visibility = View.INVISIBLE
            holder.Deny.visibility = View.INVISIBLE
        }
        else{
            holder.Approve.visibility = View.VISIBLE
            holder.Deny.visibility = View.VISIBLE
        }


    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class MLoanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var LoanNo: TextView = itemView.findViewById(com.example.bank.R.id.LoanNo)
        var LoanType: TextView = itemView.findViewById(com.example.bank.R.id.LoanType)
        var LoanBranch: TextView = itemView.findViewById(com.example.bank.R.id.LoanBranch)
        var DOC: TextView = itemView.findViewById(com.example.bank.R.id.DOC)
        var Duration: TextView = itemView.findViewById(com.example.bank.R.id.Duration)
        var Status: TextView = itemView.findViewById(com.example.bank.R.id.LoanStatus)
        var Amount: TextView = itemView.findViewById(com.example.bank.R.id.Amount)
        var RemainingAmount: TextView = itemView.findViewById(com.example.bank.R.id.RemainingAmount)

        var Approve: Button = itemView.findViewById(com.example.bank.R.id.btn_approve)
        var Deny: Button = itemView.findViewById(com.example.bank.R.id.btn_deny)



        init {
            Approve.setOnClickListener(this)
            Deny.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if(items[position].status != "Pending") {
                    listener.onItemClick(position,-1)
                }
                else if(p0?.id == com.example.bank.R.id.btn_approve)
                    listener.onItemClick(position,1)
                else if(p0?.id == com.example.bank.R.id.btn_deny)
                    listener.onItemClick(position,2)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(pos: Int,option : Int)
    }


}