package com.example.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeListAdapter(private val items: ArrayList<EmployeeData>, private val listener: OnItemClickListener):
    RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListAdapter.EmployeeViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeViewHolder(view);
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val currentItem = items[position]
        holder.EmpId.text  = "EmpID: "+currentItem.EmpID
        holder.EmpSalary.text = "Salary: "+currentItem.Salary
        holder.EmpName.text = "Name: "+currentItem.Name
        holder.EmpPhone.text = "Phone Number: "+currentItem.Number
    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var EmpId: TextView = itemView.findViewById(R.id.EmpID)
        var EmpName: TextView = itemView.findViewById(R.id.EmpName)
        var EmpPhone: TextView = itemView.findViewById(R.id.EmpPhone)
        var EmpSalary: TextView = itemView.findViewById(R.id.EmpSalary)

        var Terminate: Button = itemView.findViewById(R.id.btn_ter)
        var Salary: Button = itemView.findViewById(R.id.btn_salary)

        init {
            Terminate.setOnClickListener(this)
            Salary.setOnClickListener(this)

        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if(p0?.id == R.id.btn_ter)
                    listener.onItemClick(position,1)
                else if(p0?.id == R.id.btn_salary)
                    listener.onItemClick(position,2)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(pos: Int,option : Int)
    }
}