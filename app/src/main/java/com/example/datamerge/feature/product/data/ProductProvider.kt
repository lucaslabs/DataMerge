package com.example.datamerge.feature.product.data

import android.content.Context
import com.example.datamerge.R
import com.example.datamerge.feature.product.model.Product

class ProductProvider {

    companion object {
        fun getProduct(context: Context?): Product {
            return Product(
                R.drawable.lays,
                context?.getString(R.string.product_manufacturer),
                context?.getString(R.string.product_name),
                context?.getString(R.string.product_short_description),
                rating = 4.8,
                price = 99.9,
                discountPercentage = null,
                description = context?.getString(R.string.product_content_value),
                ingredients = context?.getString(R.string.product_content_value),
                isOnSale = false,
                isOutOfStock = false
            )
        }
    }
}