package com.example.datamerge.presentation.product_detail.adapter

import com.example.datamerge.R
import com.example.datamerge.presentation.base.BaseViewModelBindingAdapter
import com.example.datamerge.presentation.product_detail.viewmodels.ProductDescriptionViewModel

class ProductDescriptionAdapter(viewModel: ProductDescriptionViewModel) :
    BaseViewModelBindingAdapter(viewModel, R.layout.product_description_item)