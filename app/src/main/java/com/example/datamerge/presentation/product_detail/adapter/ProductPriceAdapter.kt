package com.example.datamerge.presentation.product_detail.adapter

import com.example.datamerge.R
import com.example.datamerge.presentation.base.BaseViewModelBindingAdapter
import com.example.datamerge.presentation.product_detail.viewmodels.ProductPriceViewModel

class ProductPriceAdapter(viewModel: ProductPriceViewModel) :
    BaseViewModelBindingAdapter(viewModel, R.layout.product_price_item)