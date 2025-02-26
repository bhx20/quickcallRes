package com.quickcall.res.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.quickcall.res.R
import com.quickcall.res.databinding.ItemSimpleListBinding
import com.quickcall.res.extensions.*
import com.quickcall.res.models.SimpleListItem
import com.quickcall.strings.R as stringsR

open class SimpleListItemAdapter(val activity: Activity, val onItemClicked: (SimpleListItem) -> Unit) :
    ListAdapter<SimpleListItem, SimpleListItemAdapter.SimpleItemViewHolder>(SimpleListItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleItemViewHolder {
        val view = activity.layoutInflater.inflate(R.layout.item_simple_list, parent, false)
        return SimpleItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleItemViewHolder, position: Int) {
        val route = getItem(position)
        holder.bindView(route)
    }

    open inner class SimpleItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemSimpleListBinding.bind(itemView)
        fun bindView(item: SimpleListItem) {
            setupSimpleListItem(binding, item, false, onItemClicked)
        }
    }

    private class SimpleListItemDiffCallback : DiffUtil.ItemCallback<SimpleListItem>() {
        override fun areItemsTheSame(oldItem: SimpleListItem, newItem: SimpleListItem): Boolean {
            return SimpleListItem.areItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: SimpleListItem, newItem: SimpleListItem): Boolean {
            return SimpleListItem.areContentsTheSame(oldItem, newItem)
        }
    }
}

fun setupSimpleListItem(view: ItemSimpleListBinding, item: SimpleListItem, collection: Boolean, onItemClicked: (SimpleListItem) -> Unit) {
    view.apply {
        if (collection) {
            bottomSheetSelectedIcon.beGone()

            bottomSheetItemIcon.setImageResourceOrBeGone(item.imageRes)
            //bottomSheetItemIcon.applyColorFilter(color)

            if (item.textRes != null) bottomSheetItemTitle.setText(item.textRes)
            if (item.text != null) bottomSheetItemTitle.text = item.text
            bottomSheetItemTitle.setTextColor(root.context.getProperTextColor())
            if (!item.selected) {
                bottomSheetItemTitle.alpha = 0.4f
                bottomSheetItemIcon.alpha = 0.4f
            }

            bottomSheetButton.beVisible()
            val textButton = if (item.selected) stringsR.string.open else stringsR.string.get
            bottomSheetButton.setText(textButton)
            val drawable = root.resources.getColoredDrawableWithColor(root.context, R.drawable.button_gray_bg, root.context.getProperPrimaryColor())
            bottomSheetButton.background = drawable
            bottomSheetButton.setTextColor(root.context.getProperBackgroundColor())
            bottomSheetButton.setPadding(2,2,2,2)

            root.setOnClickListener {
                onItemClicked(item)
            }
        } else {
            bottomSheetButton.beGone()

            val color = if (item.selected) {
                root.context.getProperPrimaryColor()
            } else {
                root.context.getProperTextColor()
            }

            bottomSheetItemIcon.setImageResourceOrBeGone(item.imageRes)
            bottomSheetItemIcon.applyColorFilter(color)

            if (item.textRes != null) bottomSheetItemTitle.setText(item.textRes)
            if (item.text != null) bottomSheetItemTitle.text = item.text
            bottomSheetItemTitle.setTextColor(color)

            //bottomSheetSelectedIcon.beVisibleIf(item.selected)
            bottomSheetSelectedIcon.beVisible()
            val selectedIcon = if (item.selected) R.drawable.ic_check_circle_vector else R.drawable.ic_circle
            bottomSheetSelectedIcon.setImageResource(selectedIcon)
            bottomSheetSelectedIcon.applyColorFilter(color)

            root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}
