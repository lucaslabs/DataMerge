package com.example.datamerge.presentation.product_detail.viewstate

import androidx.databinding.Bindable
import com.example.datamerge.presentation.base.BaseViewState
import com.example.datamerge.presentation.product_detail.adapter.ProductImageAdapter

class ProductGalleryViewState(private val productImageAdapter: ProductImageAdapter) :
    BaseViewState() {

    @Bindable
    var adapter = productImageAdapter
}