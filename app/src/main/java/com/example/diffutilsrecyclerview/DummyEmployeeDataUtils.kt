package com.example.diffutilsrecyclerview

import kotlin.collections.ArrayList

object DummyEmployeeDataUtils {
    fun getEmployeeListSortedByName(): ArrayList<Employee> {
        val employeeList = getHugeEmployeeList()
        employeeList.sortWith { o1, o2 -> o1!!.name.compareTo(o2!!.name) }
        return employeeList
    }

    fun getEmployeeListSortedByRole(): ArrayList<Employee> {
        val employeeList = getHugeEmployeeList()
        employeeList.sortWith { o1, o2 -> o1!!.role.compareTo(o2!!.role) }
        return employeeList
    }

      private fun getEmployeeList(): ArrayList<Employee> {
        val employees = ArrayList<Employee>()
        employees.add(Employee(1, "Employee 1", "Developer"))
        employees.add(Employee(2, "Employee 2", "Tester"))
        employees.add(Employee(3, "Employee 3", "Support"))
        employees.add(Employee(4, "Employee 4", "Sales Manager"))
        employees.add(Employee(5, "Employee 5", "Manager"))
        employees.add(Employee(6, "Employee 6", "Team lead"))
        employees.add(Employee(7, "Employee 7", "Scrum Master"))
        employees.add(Employee(8, "Employee 8", "Sr. Tester"))
        employees.add(Employee(9, "Employee 9", "Sr. Developer"))
        return employees as ArrayList<Employee>
    }
    fun getHugeEmployeeList(): ArrayList<Employee>{
        val employees = ArrayList<Employee>()
        (1..50).forEach {
            employees.add(Employee(it, name = "Employee $it", role = "Role$it"))
        }
        return employees
    }
}