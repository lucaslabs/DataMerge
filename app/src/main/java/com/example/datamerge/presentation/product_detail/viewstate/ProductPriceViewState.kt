package com.example.datamerge.presentation.product_detail.viewstate

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import androidx.databinding.Bindable
import com.example.datamerge.data.Product
import com.example.datamerge.presentation.base.BaseViewState
import java.math.RoundingMode
import java.text.DecimalFormat

class ProductPriceViewState(private val product: Product) : BaseViewState() {

    // region Bindable
    @Bindable
    var manufacturer = product.manufacturer

    @Bindable
    var name = product.nameResId // Binding Adapter example

    @Bindable
    var shortDescription = product.shortDescription

    @Bindable
    var rating = product.rating.toString()

    @Bindable
    fun getPrice(): String {
        var price = ""
        product.discountPercentage?.let { discount ->
            price = formatToDecimal(product.price - (product.price * discount / 100))
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

    private fun formatToDecimal(value: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(value)
    }
}