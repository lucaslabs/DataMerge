package com.example.datamerge.feature.product.model

data class Product(
    val imageUrl: String?,
    val manufacturer: String?,
    val name: String?,
    val shortDescription: String?,
    val rating: Double,
    val price: Double,
    val discountPercentage: Int?,
    val maxQuantity: Int,
    val minQuantity: Int,
    val description: String?,
    val ingredients: String?,
    val isOutOfStock: Boolean
)