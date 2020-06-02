package com.example.datamerge.presentation.product_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.datamerge.R
import com.example.datamerge.data.Product
import com.example.datamerge.databinding.ProductPriceItemBinding
import com.example.datamerge.presentation.product_detail.viewstate.ProductPriceViewState

class ProductPriceAdapter(private val product: Product) :
    RecyclerView.Adapter<ProductPriceAdapter.ProductPriceViewHolder>() {

    private lateinit var binding: ProductPriceItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductPriceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.product_price_item,
            parent,
            false
        )
        return ProductPriceViewHolder(binding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: ProductPriceViewHolder, position: Int) {
        holder.bind(product)
    }

    inner class ProductPriceViewHolder(binding: ProductPriceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.viewState = ProductPriceViewState(product)
            binding.executePendingBindings()
        }
    }
}