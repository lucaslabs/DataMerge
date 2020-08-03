package com.example.datamerge.presentation.product_detail.adapter

import com.example.datamerge.R
import com.example.datamerge.presentation.base.BaseViewModelBindingAdapter
import com.example.datamerge.presentation.product_detail.viewmodels.ProductIngredientsViewModel

class ProductIngredientsAdapter(viewModel: ProductIngredientsViewModel) :
    BaseViewModelBindingAdapter(viewModel, R.layout.product_ingredients_item)