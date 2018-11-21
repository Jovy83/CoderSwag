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

class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter() {

    val context = context
    val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // similar to cellForRow (indexPath) from iOS
        val categoryView: View
        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
        val categoryImage : ImageView = categoryView.categoryImage
        val categoryName : TextView = categoryView.categoryName

        val category = categories[position]

        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryImage.setImageResource(resourceId)
        println(resourceId)

        categoryName.text = category.title
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


}