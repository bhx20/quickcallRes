package com.quickcall.res.interfaces

import androidx.recyclerview.widget.RecyclerView

interface StartReorderDragListener {
    fun requestDrag(viewHolder: RecyclerView.ViewHolder)
}
