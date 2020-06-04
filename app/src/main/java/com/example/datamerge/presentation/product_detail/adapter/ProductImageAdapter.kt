package com.example.datamerge.presentation.product_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.datamerge.BR
import com.example.datamerge.R
import com.example.datamerge.databinding.ProductImageItemBinding
import com.example.datamerge.presentation.base.BaseViewState
import com.example.datamerge.presentation.product_detail.viewstate.ProductImageViewState

class ProductImageAdapter(private val imagesUrl: List<String>) :
    RecyclerView.Adapter<ProductImageAdapter.ProductImageViewHolder>() {

    private lateinit var binding: ProductImageItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.product_image_item, parent, false)
        return ProductImageViewHolder(binding)
    }

    override fun getItemCount() = imagesUrl.size

    override fun onBindViewHolder(holder: ProductImageViewHolder, position: Int) {
        val viewState = ProductImageViewState(imagesUrl[position])
        holder.bind(viewState)

        holder.itemView.setOnClickListener { view ->
            Toast.makeText(view.context, "Clicked image $position", Toast.LENGTH_SHORT).show()
        }
    }

    inner class ProductImageViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewState: BaseViewState) {
            binding.setVariable(BR.viewState, viewState)
            binding.executePendingBindings()
        }
    }
}