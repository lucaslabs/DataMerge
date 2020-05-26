package com.example.datamerge.binding

import android.graphics.Bitmap
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.datamerge.R
import com.example.datamerge.base.GlideApp

// Top Level Functions
@BindingAdapter("android:text")
fun setTextViewResource(view: TextView, resId: Int) {
    view.setText(resId)
}

@BindingAdapter(value = ["app:imageUrl", "app:errorImage"], requireAll = false)
fun setImageUrl(
    imageView: ImageView,
    imageUrl: String?,
    imageWidth: Int
) {
    GlideApp.with(imageView)
        .asBitmap()
        .load(imageUrl)
        .placeholder(R.drawable.product_placeholder)
        .encodeFormat(Bitmap.CompressFormat.PNG)
        .fitCenter()
        .into(imageView)
}