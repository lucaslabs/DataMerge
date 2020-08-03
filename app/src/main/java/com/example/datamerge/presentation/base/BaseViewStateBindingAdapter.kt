package com.example.datamerge.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.datamerge.BR

abstract class BaseViewStateBindingAdapter(
    private val viewState: BaseViewState,
    private val layoutResId: Int
) : RecyclerView.Adapter<BaseViewStateBindingAdapter.ViewHolder>() {

    lateinit var binding: ViewDataBinding

    override fun getItemCount() = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(
            layoutInflater, layoutResId, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viewState)
    }

    inner class ViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewState: BaseViewState) {
            binding.setVariable(BR.viewState, viewState)
            binding.executePendingBindings()
        }
    }
}