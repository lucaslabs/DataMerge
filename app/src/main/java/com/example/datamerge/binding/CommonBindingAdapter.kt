package com.example.datamerge.binding

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestListener
import com.example.datamerge.R
import com.example.datamerge.base.GlideApp

// Top Level Functions
@BindingAdapter("android:text")
fun setTextViewResource(view: TextView, resId: Int) {
    view.setText(resId)
}

@BindingAdapter(value = ["imageUrl", "imageRequestListener"], requireAll = false)
fun setImageUrl(imageView: ImageView, url: String?, listener: RequestListener<Drawable?>?)  {
    GlideApp.with(imageView)
        .load(url)
        .listener(listener)
        .into(imageView)
}