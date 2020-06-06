package com.example.datamerge.presentation.product_detail.adapter

import com.example.datamerge.R
import com.example.datamerge.presentation.base.BaseBindingAdapter
import com.example.datamerge.presentation.product_detail.viewstate.ProductOutOfStockViewState

class ProductOutOfStockAdapter : BaseBindingAdapter() {

    override fun createViewState() = ProductOutOfStockViewState()

    override fun getLayoutResId() = R.layout.product_out_of_stock_item
}