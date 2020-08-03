package com.example.datamerge.presentation.product_detail.viewstates

import android.view.View
import android.widget.Toast
import androidx.databinding.Bindable
import com.example.datamerge.presentation.base.BaseViewState

class ProductImageViewState(@Bindable var imageUrl: String, private val position: Int) :
    BaseViewState(),
    View.OnClickListener {

    override fun onClick(v: View?) {
        Toast.makeText(v?.context, "Image #$position clicked!", Toast.LENGTH_SHORT).show()
    }
}