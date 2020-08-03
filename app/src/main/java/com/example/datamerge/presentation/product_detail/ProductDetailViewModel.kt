package com.example.datamerge.presentation.product_detail

import android.view.View
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datamerge.BR
import com.example.datamerge.R
import com.example.datamerge.data.Product
import com.example.datamerge.presentation.base.BaseViewModel
import com.example.datamerge.presentation.binding.widget.QuantityStepperView

class ProductDetailViewModel(private val product: Product) : BaseViewModel(), View.OnClickListener,
    QuantityStepperView.OnQuantityStepperClickListener {

    private var addToCartButtonEnabled = !product.isOutOfStock
    private var isProductInCart = false
    private var qtyStepperEnabled = true

    // region Bindable
    @Bindable
    fun getAddToCartButtonEnabled() = addToCartButtonEnabled

    @Bindable
    fun getAddToCartButtonVisibility(): Int {
        return if (!isProductInCart) View.VISIBLE else View.GONE
    }

    @Bindable
    fun getQuantityStepperEnabled() = qtyStepperEnabled

    @Bindable
    fun getQuantityStepperVisibility(): Int {
        return if (isProductInCart) View.VISIBLE else View.GONE
    }

    @Bindable
    fun getQuantityStepperMaximum() = product.maxQuantity

    @Bindable
    fun getQuantityStepperMinimum() = product.minQuantity

    @Bindable
    fun getQuantityStepperQuantity() = product.minQuantity
    // endregion

    fun setQuantityStepperEnabled(enabled: Boolean) {
        qtyStepperEnabled = enabled
        notifyPropertyChanged(BR.quantityStepperEnabled)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_add_to_cart -> {
                Toast.makeText(v.context, "Product added to cart", Toast.LENGTH_SHORT).show()
                addToCart()
            }
        }
    }

    override fun onIncrementClick(v: View?, quantity: Int) {
        // TODO Call to service to increment quantity
        Toast.makeText(v?.context, "Increment", Toast.LENGTH_SHORT).show()
    }

    override fun onDecrementClick(v: View?, quantity: Int) {
        if (quantity == 0) {
            // TODO Call to service to remove product
            Toast.makeText(v?.context, "Remove product", Toast.LENGTH_SHORT).show()
            toggleButtonVisibility(true)
        } else {
            // TODO Call to service to increment quantity
            Toast.makeText(v?.context, "Decrement", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addToCart() {
        toggleButtonVisibility(false)
        notifyPropertyChanged(BR.quantityStepperQuantity)
    }

    private fun toggleButtonVisibility(addToCartEnabled: Boolean) {
        addToCartButtonEnabled = addToCartEnabled
        isProductInCart = !addToCartEnabled
        notifyPropertyChanged(BR.addToCartButtonEnabled)
        notifyPropertyChanged(BR.addToCartButtonVisibility)
        notifyPropertyChanged(BR.quantityStepperVisibility)
    }

    class Factory(private val product: Product) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            ProductDetailViewModel(product) as T
    }
}