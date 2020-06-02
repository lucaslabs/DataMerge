package com.example.datamerge.data

import com.example.datamerge.R

class ProductProvider {

    companion object {
        fun getProduct(): Product {
            return Product(
                imageUrl = "https://img.thrivemarket.com/store/full/8/5/852565003305-1_1.jpg",
                manufacturer = "Beanfields",
                nameResId = R.string.product_name,
                shortDescription = "5.5 oz bag",
                rating = 4.62,
                price = 3.79,
                discountPercentage = 15,
                maxQuantity = 5,
                minQuantity = 1,
                description = "Traditional potato chips are no match for Beanfields Jalapeno Nacho Bean and Rice Chips, which are corn-free, and made without a single one of the eight ingredients recognized by the FDA as potential allergens. These spicy, cheesy crisps are also gluten-free, vegan, and contain no GMOs or added sugar. Plus, they pack 150 percent more protein, 200 percent more fiber, and 44 percent less fat than your average tortilla chip. So go ahead and treat yourself to a snack without any of the guilt.",
                ingredients = "Black Beans, Navy Beans, Brown Rice, Safflower or Sunflower Oil, Salt, Jalapeño Pepper.",
                isOutOfStock = false
            )
        }
    }
}