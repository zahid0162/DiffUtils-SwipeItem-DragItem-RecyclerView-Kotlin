package com.example.diffutilsrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class EmployeeRecyclerViewAdapter( val mEmployees: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeRecyclerViewAdapter
.ViewHolder>() {
    private var mRecentlyDeletedItem:Employee?=null
    private var mRecentlyDeletedItemPosition=0
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val role: TextView
         val name: TextView

        init {
            name = itemView.findViewById(R.id.employee_name)
            role = itemView.findViewById(R.id.employee_role)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.list_item,parent,false))
    }
    fun updateEmployeeListItems(employees: ArrayList<Employee>) {
        val diffCallback = EmployeeDiffCallBack(mEmployees, employees)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        mEmployees.clear()
        mEmployees.addAll(employees)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return mEmployees.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text=mEmployees[position].name
        holder.role.text = mEmployees[position].role;
    }

    fun removeItem(adapterPosition: Int) {
        mRecentlyDeletedItemPosition=adapterPosition
        mRecentlyDeletedItem=mEmployees[adapterPosition]
        mEmployees.removeAt(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }

}
