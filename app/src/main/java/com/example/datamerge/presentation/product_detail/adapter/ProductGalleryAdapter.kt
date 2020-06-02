package com.example.datamerge.presentation.product_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.datamerge.R
import com.example.datamerge.databinding.ProductGalleryItemBinding
import com.example.datamerge.presentation.product_detail.viewstate.ProductGalleryViewState

class ProductGalleryAdapter(private val imagesUrl: List<String>) :
    RecyclerView.Adapter<ProductGalleryAdapter.ProductGalleryViewHolder>() {

    private lateinit var binding: ProductGalleryItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductGalleryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.product_gallery_item,
            parent,
            false
        )
        return ProductGalleryViewHolder(binding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: ProductGalleryViewHolder, position: Int) {
        holder.bind(imagesUrl)
    }

    inner class ProductGalleryViewHolder(binding: ProductGalleryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imagesUrl: List<String>) {
            binding.viewState = ProductGalleryViewState(imagesUrl)
            binding.executePendingBindings()
        }
    }
}