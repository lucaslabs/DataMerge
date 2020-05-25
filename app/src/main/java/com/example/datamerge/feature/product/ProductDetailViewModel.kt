package com.example.datamerge.feature.product

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datamerge.base.BaseViewModel
import com.example.datamerge.feature.product.model.Product
import java.math.RoundingMode
import java.text.DecimalFormat


@BindingAdapter("android:src")
fun setImageViewResource(view: ImageView, resId: Int) {
    view.setImageResource(resId)
}

class ProductDetailViewModel(private val product: Product) : BaseViewModel() {

    @Bindable
    var image = product.imageResId

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
        var price = "\$${product.price}"
        product.discountPercentage?.let {
            price =
                formatToDecimal(product.price - (product.price * product.discountPercentage / 100))
            return "\$$price"
        } ?: run {
            return price
        }
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


    class ProductDetailViewModelFactory(private val product: Product) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            ProductDetailViewModel(product) as T
    }

    private fun formatToDecimal(value: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(value)
    }
}