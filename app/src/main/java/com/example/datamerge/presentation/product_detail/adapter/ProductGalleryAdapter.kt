package com.example.datamerge.presentation.product_detail.adapter

import com.example.datamerge.R
import com.example.datamerge.presentation.binding.BaseBindingAdapter
import com.example.datamerge.presentation.product_detail.viewstate.ProductGalleryViewState

class ProductGalleryAdapter(private val imagesUrl: List<String>) : BaseBindingAdapter() {

    override fun createViewState() = ProductGalleryViewState(imagesUrl)

    override fun getLayoutResId() = R.layout.product_gallery_item
}