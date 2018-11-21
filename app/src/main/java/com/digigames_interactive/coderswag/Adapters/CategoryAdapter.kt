package com.digigames_interactive.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.digigames_interactive.coderswag.Model.Category
import com.digigames_interactive.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // similar to cellForRow (indexPath) from iOS
        val categoryView: View
        val holder: ViewHolder

        if (convertView == null) {
            // means this is the very first time the views are being presented
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.categoryImage
            holder.categoryName = categoryView.categoryName
            println("I exist for the first time")
            categoryView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
            println("Go green, recycle!")
        }

        val category = categories[position]

        // takes in a string, resource type, and the package name
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    // method that defines a unique ID for each row. but we're not going to use it
    override fun getItemId(position: Int): Long {
        return 0
    }


    override fun getCount(): Int {
        // similar to numberOfRows from iOS
        return categories.count()
    }

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}