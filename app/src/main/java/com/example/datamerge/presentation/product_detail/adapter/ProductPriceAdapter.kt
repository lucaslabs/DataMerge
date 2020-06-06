package com.example.datamerge.presentation.product_detail.adapter

import com.example.datamerge.R
import com.example.datamerge.data.Product
import com.example.datamerge.presentation.base.BaseBindingAdapter
import com.example.datamerge.presentation.product_detail.viewstate.ProductPriceViewState

class ProductPriceAdapter(private val product: Product) : BaseBindingAdapter() {

    override fun createViewState() = ProductPriceViewState(product)

    override fun getLayoutResId() = R.layout.product_price_item
}