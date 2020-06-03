package com.example.datamerge.presentation.product_detail.adapter

import com.example.datamerge.R
import com.example.datamerge.presentation.binding.BaseBindingAdapter
import com.example.datamerge.presentation.product_detail.viewstate.ProductDescriptionViewState

class ProductDescriptionAdapter(private val title: String, private val description: String) :
    BaseBindingAdapter() {

    override fun createViewState() = ProductDescriptionViewState(title, description)

    override fun getLayoutResId() = R.layout.product_description_item
}
