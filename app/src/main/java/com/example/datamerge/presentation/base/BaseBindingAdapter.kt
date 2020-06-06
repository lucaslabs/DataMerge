package com.example.datamerge.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.datamerge.BR

abstract class BaseBindingAdapter :
    RecyclerView.Adapter<BaseBindingAdapter.BaseBindingViewHolder>() {

    override fun getItemCount() = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, getLayoutResId(), parent, false)
        return BaseBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder, position: Int) {
        val viewState = createViewState()
        holder.bind(viewState)
    }

    abstract fun createViewState(): BaseViewState

    abstract fun getLayoutResId(): Int

    inner class BaseBindingViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewState: BaseViewState) {
            binding.setVariable(BR.viewState, viewState)
            binding.executePendingBindings()
        }
    }
}