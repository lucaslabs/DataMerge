package com.example.datamerge.presentation.product_detail.viewstate

import android.view.View
import android.widget.Toast
import androidx.databinding.Bindable
import com.example.datamerge.R
import com.example.datamerge.presentation.base.BaseViewState

class ProductOutOfStockViewState : BaseViewState(), View.OnClickListener {

    @Bindable
    var notifyText = R.string.notify_product_in_stock

    override fun onClick(v: View?) {
        Toast.makeText(v?.context, "Notify clicked!", Toast.LENGTH_LONG).show()
    }
}