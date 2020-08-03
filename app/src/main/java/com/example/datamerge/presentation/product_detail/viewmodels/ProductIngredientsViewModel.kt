package com.example.datamerge.presentation.product_detail.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datamerge.R
import com.example.datamerge.data.Product
import com.example.datamerge.presentation.base.BaseViewModel

class ProductIngredientsViewModel(product: Product) :
    BaseViewModel() {

    @Bindable
    var title = R.string.product_ingredients_title

    @Bindable
    var ingredients = product.ingredients

    class Factory(private val product: Product) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            ProductIngredientsViewModel(product) as T
    }
}