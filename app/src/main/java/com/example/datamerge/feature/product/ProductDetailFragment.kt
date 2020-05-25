package com.example.datamerge.feature.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.datamerge.R
import com.example.datamerge.databinding.ProductDetailFragmentBinding
import com.example.datamerge.feature.product.data.ProductProvider

class ProductDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            ProductDetailFragment()
    }

    private val viewModel: ProductDetailViewModel by viewModels {
        ProductDetailViewModel.ProductDetailViewModelFactory(
            ProductProvider.getProduct(context)
        )
    }

    private lateinit var binding: ProductDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.product_detail_fragment,
            container, false
        )
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }
}
