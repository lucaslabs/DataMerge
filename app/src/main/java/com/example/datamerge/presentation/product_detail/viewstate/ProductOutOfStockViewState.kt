package com.example.datamerge.presentation.product_detail.viewstate

import android.view.View
import android.widget.Toast
import com.example.datamerge.presentation.base.BaseViewState

class ProductOutOfStockViewState : BaseViewState(), View.OnClickListener {

    override fun onClick(v: View?) {
        Toast.makeText(v?.context, "Notify clicked!", Toast.LENGTH_LONG).show()
    }
}