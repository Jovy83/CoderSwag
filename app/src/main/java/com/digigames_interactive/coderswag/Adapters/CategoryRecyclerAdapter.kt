package com.digigames_interactive.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.digigames_interactive.coderswag.Model.Category
import com.digigames_interactive.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryRecyclerAdapter(val context: Context, val categories: List<Category>, val itemClick: (Category) -> Unit) : RecyclerView.Adapter<CategoryRecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        // this is where we inflate the view for the very first time
        // we can either pass the context from the constructor above, or use the parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)

        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position], context)
    }

    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView.categoryImage
        val categoryName = itemView.categoryName

        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title

            itemView.setOnClickListener { itemClick(category) }
        }
    }
}