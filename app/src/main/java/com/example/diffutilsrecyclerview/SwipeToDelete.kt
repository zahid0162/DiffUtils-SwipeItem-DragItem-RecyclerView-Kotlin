package com.example.diffutilsrecyclerview

import android.graphics.Color
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_DRAG
import androidx.recyclerview.widget.RecyclerView

class SwipeToDelete(val adapter: EmployeeRecyclerViewAdapter) : ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.UP or ItemTouchHelper.DOWN,
    ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.notifyItemMoved(viewHolder.adapterPosition,target.adapterPosition)
        return true
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        if (actionState == ACTION_STATE_DRAG) {
            viewHolder?.itemView?.alpha = 0.5f
        }
    }
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.removeItem(viewHolder.adapterPosition)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        viewHolder.itemView.alpha=1.0f
    }

}