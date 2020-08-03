package com.example.datamerge.presentation.product_detail.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datamerge.R
import com.example.datamerge.data.Product
import com.example.datamerge.presentation.base.BaseViewModel

class ProductDescriptionViewModel(product: Product) :
    BaseViewModel() {

    @Bindable
    var title = R.string.product_description_title

    @Bindable
    var description = product.description

    class Factory(private val product: Product) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            ProductDescriptionViewModel(product) as T
    }
}