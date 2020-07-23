package com.example.datamerge.presentation.product_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.datamerge.BR
import com.example.datamerge.R
import com.example.datamerge.databinding.ProductOutOfStockItemBinding

class ProductOutOfStockAdapter(private val viewModel: ViewModel) :
    RecyclerView.Adapter<ProductOutOfStockAdapter.ProductOutOfStockViewHolder>() {

    lateinit var binding: ProductOutOfStockItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductOutOfStockViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(
            layoutInflater, R.layout.product_out_of_stock_item, parent, false
        )
        return ProductOutOfStockViewHolder(binding)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: ProductOutOfStockViewHolder, position: Int) {
        holder.bind(viewModel)
    }

    inner class ProductOutOfStockViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: ViewModel) {
            binding.setVariable(BR.viewModel, viewModel)
            binding.executePendingBindings()
        }
    }
}