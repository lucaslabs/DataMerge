package com.example.datamerge.feature.product

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datamerge.BR
import com.example.datamerge.R
import com.example.datamerge.base.BaseViewModel
import com.example.datamerge.feature.product.model.Product
import java.math.RoundingMode
import java.text.DecimalFormat

class ProductDetailViewModel(private val product: Product) : BaseViewModel(), View.OnClickListener {

    private var addToCartButtonEnabled = true
    private var isProductInCart = false

    @Bindable
    var imageUrl = product.imageUrl

    @Bindable
    var manufacturer = product.manufacturer

    @Bindable
    var name = product.name

    @Bindable
    var shortDescription = product.shortDescription

    @Bindable
    var rating = product.rating.toString()

    @Bindable
    fun getPrice(): String {
        var price = ""
        product.discountPercentage?.let {
            price =
                formatToDecimal(product.price - (product.price * product.discountPercentage / 100))
        } ?: run {
            price = product.price.toString()
        }
        return "\$$price"
    }

    @Bindable
    fun getDiscount(): SpannableString? {
        product.discountPercentage?.let {
            val price = product.price.toString()
            val span = SpannableString("\$$price")
            span.setSpan(
                StrikethroughSpan(), 0, span.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            return span
        } ?: return null
    }

    @Bindable
    var description = product.description

    @Bindable
    var ingredients = product.ingredients

    @Bindable
    fun getAddToCartButtonEnabled() = addToCartButtonEnabled

    @Bindable
    fun getAddToCartButtonText(): Int {
        return if (!isProductInCart) R.string.btn_add_to_cart else R.string.btn_added_to_cart
    }

    class ProductDetailViewModelFactory(private val product: Product) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            ProductDetailViewModel(product) as T
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_add_to_cart -> {
                addToCart()
            }
        }
    }

    private fun addToCart() {
        addToCartButtonEnabled = false
        isProductInCart = true
        notifyPropertyChanged(BR.addToCartButtonEnabled)
        notifyPropertyChanged(BR.addToCartButtonText)
    }

    private fun formatToDecimal(value: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(value)
    }
}