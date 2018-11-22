package com.digigames_interactive.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.digigames_interactive.coderswag.Adapters.ProductsRecylerAdapter
import com.digigames_interactive.coderswag.R
import com.digigames_interactive.coderswag.Services.DataService
import com.digigames_interactive.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsRecylerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsRecylerAdapter(this, DataService.getProducts(categoryType))

        var spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 3
        spanCount = if (resources.configuration.screenWidthDp > 720) 4 else spanCount   // the xl screen size start at 720dp

        // span count is number of columns
        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}
