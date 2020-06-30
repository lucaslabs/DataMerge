package com.example.datamerge.presentation.product_detail.viewstate

import android.view.View
import android.widget.Toast
import androidx.databinding.Bindable
import com.example.datamerge.presentation.base.BaseViewState

class ProductImageViewState(image: String) : BaseViewState(), View.OnClickListener {

    @Bindable
    var imageUrl = image

    override fun onClick(v: View?) {
        Toast.makeText(v?.context, "Image clicked!", Toast.LENGTH_SHORT).show()
    }
}