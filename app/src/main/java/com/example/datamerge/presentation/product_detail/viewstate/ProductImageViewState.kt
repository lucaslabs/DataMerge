package com.example.datamerge.presentation.product_detail.viewstate

import androidx.databinding.Bindable
import com.example.datamerge.presentation.base.BaseViewState

class ProductImageViewState(image: String) : BaseViewState() {

    @Bindable
    var imageUrl = image
}