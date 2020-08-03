package com.example.datamerge.presentation.product_detail.adapter

import com.example.datamerge.R
import com.example.datamerge.presentation.base.BaseViewModelBindingAdapter
import com.example.datamerge.presentation.product_detail.viewmodels.ProductOutOfStockViewModel

class ProductOutOfStockAdapter(viewModel: ProductOutOfStockViewModel) :
    BaseViewModelBindingAdapter(viewModel, R.layout.product_out_of_stock_item)