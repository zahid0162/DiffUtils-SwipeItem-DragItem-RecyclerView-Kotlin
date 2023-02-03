package com.example.diffutilsrecyclerview

import androidx.recyclerview.widget.DiffUtil

class EmployeeDiffCallBack(old:ArrayList<Employee>,new:ArrayList<Employee>) :DiffUtil.Callback() {
    private val mOldEmployeeList: ArrayList<Employee>
    private val mNewEmployeeList: ArrayList<Employee>
    init {
        mNewEmployeeList=new
        mOldEmployeeList=old
    }
    override fun getOldListSize(): Int {
        return mOldEmployeeList.size ?: 0
    }

    override fun getNewListSize(): Int {
        return mNewEmployeeList.size ?: 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldEmployeeList[oldItemPosition].id == mNewEmployeeList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldEmployeeList[oldItemPosition] == mNewEmployeeList[newItemPosition]
    }


}