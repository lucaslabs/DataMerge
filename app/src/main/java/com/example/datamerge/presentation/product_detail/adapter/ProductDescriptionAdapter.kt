package com.example.datamerge.presentation.product_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.datamerge.R
import com.example.datamerge.databinding.ProductDescriptionItemBinding
import com.example.datamerge.presentation.product_detail.viewstate.ProductDescriptionViewState

class ProductDescriptionAdapter(private val title: String, private val description: String) :
    RecyclerView.Adapter<ProductDescriptionAdapter.ProductDescriptionViewHolder>() {

    private lateinit var binding: ProductDescriptionItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDescriptionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.product_description_item,
            parent,
            false
        )
        return ProductDescriptionViewHolder(binding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: ProductDescriptionViewHolder, position: Int) {
        holder.bind(title, description)
    }

    inner class ProductDescriptionViewHolder(binding: ProductDescriptionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(title: String, description: String) {
            binding.viewState = ProductDescriptionViewState(title, description)
            binding.executePendingBindings()
        }
    }
}