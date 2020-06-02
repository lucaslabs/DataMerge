package com.example.datamerge.presentation.product_detail.viewstate

import androidx.databinding.Bindable
import com.example.datamerge.presentation.base.BaseViewState

class ProductGalleryViewState(private val imagesUrl: List<String>) : BaseViewState() {

    @Bindable
    var imageUrl = imagesUrl[0]
}