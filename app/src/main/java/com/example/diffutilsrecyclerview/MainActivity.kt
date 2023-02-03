package com.example.diffutilsrecyclerview


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutilsrecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private lateinit var mRecyclerViewAdapter: EmployeeRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mRecyclerViewAdapter = EmployeeRecyclerViewAdapter(
            DummyEmployeeDataUtils.getHugeEmployeeList()
        )
        println("Size" + DummyEmployeeDataUtils.getEmployeeListSortedByRole().size)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = mRecyclerViewAdapter
        val itemTouchHelper=ItemTouchHelper(SwipeToDelete(mRecyclerViewAdapter))
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sort_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sort_by_name -> {
                mRecyclerViewAdapter.updateEmployeeListItems(
                    DummyEmployeeDataUtils.getEmployeeListSortedByName()
                )
                return true
            }
            R.id.sort_by_role -> {
                mRecyclerViewAdapter.updateEmployeeListItems(
                    DummyEmployeeDataUtils.getEmployeeListSortedByRole()
                )
                return true
            }
            R.id.import_data -> {
                mRecyclerViewAdapter = EmployeeRecyclerViewAdapter(
            DummyEmployeeDataUtils.getHugeEmployeeList()
        )
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}