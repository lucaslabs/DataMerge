package com.example.datamerge.presentation.product_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.datamerge.R
import com.example.datamerge.databinding.ProductOutOfStockItemBinding
import com.example.datamerge.presentation.product_detail.viewstate.ProductOutOfStockViewState

class ProductOutOfStockAdapter :
    RecyclerView.Adapter<ProductOutOfStockAdapter.ProductOutOfStockViewHolder>() {

    private lateinit var binding: ProductOutOfStockItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductOutOfStockViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.product_out_of_stock_item,
            parent,
            false
        )
        return ProductOutOfStockViewHolder(binding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: ProductOutOfStockViewHolder, position: Int) {
        holder.bind()
    }

    inner class ProductOutOfStockViewHolder(binding: ProductOutOfStockItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.viewState = ProductOutOfStockViewState()
            binding.executePendingBindings()
        }
    }
}