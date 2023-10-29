package com.example.gmailpratice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter(private val items: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView: View
        var itemViewHolder: ItemViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item_model, parent, false)

            itemViewHolder = ItemViewHolder(itemView)
            itemView.tag = itemViewHolder
        } else {
            itemView = convertView
            itemViewHolder = itemView.tag as ItemViewHolder
        }

        itemViewHolder.title.text = items[position].title
        itemViewHolder.image.setImageResource(items[position].image)
        itemViewHolder.desc.text = items[position].desc
        itemViewHolder.date.text = items[position].date
        itemViewHolder.checkSelected.isChecked = items[position].selected

        val checkboxBackground = if (items[position].selected) {
            R.drawable.yellowstar
        } else {
            R.drawable.blackstar
        }
        itemViewHolder.checkSelected.setBackgroundResource(checkboxBackground)

        itemViewHolder.checkSelected.setOnClickListener {
            items[position].selected = itemViewHolder.checkSelected.isChecked
            notifyDataSetChanged()
        }

        return itemView
    }

    class ItemViewHolder(itemView: View) {
        val image: ImageView
        val title: TextView
        val desc: TextView
        val date: TextView
        val checkSelected: CheckBox
        init {
            image = itemView.findViewById(R.id.image)
            title = itemView.findViewById(R.id.text_title)
            desc = itemView.findViewById(R.id.text_desc)
            date = itemView.findViewById(R.id.text_date)
            checkSelected = itemView.findViewById(R.id.check_selected)

            Log.v("TAG", "findViewById")
        }
    }

}