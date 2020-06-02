package com.example.datamerge.presentation.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.example.datamerge.R
import com.example.datamerge.data.ProductProvider
import com.example.datamerge.databinding.ProductDetailFragmentBinding
import com.example.datamerge.presentation.product_detail.adapter.ProductDescriptionAdapter
import com.example.datamerge.presentation.product_detail.adapter.ProductGalleryAdapter
import com.example.datamerge.presentation.product_detail.adapter.ProductPriceAdapter

class ProductDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            ProductDetailFragment()
    }

    private lateinit var binding: ProductDetailFragmentBinding
    private val viewModel: ProductDetailViewModel by viewModels {
        ProductDetailViewModel.ProductDetailViewModelFactory(
            ProductProvider.getProduct()
        )
    }

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

        setupAdapters()
    }

    private fun setupAdapters() {
        binding.rvProductDetail.layoutManager = LinearLayoutManager(activity)

        val product = ProductProvider.getProduct()

        val productGalleryAdapter = ProductGalleryAdapter(listOf(product.imageUrl, product.imageUrl))
        val productPriceAdapter = ProductPriceAdapter(product)
        val productDescriptionAdapter = ProductDescriptionAdapter(getString(R.string.product_description_title), product.description)
        val productIngredientsAdapter = ProductDescriptionAdapter(getString(R.string.product_ingredients_title), product.ingredients)

        val adapterList = listOf(productGalleryAdapter, productPriceAdapter, productDescriptionAdapter, productIngredientsAdapter)
        val mergeAdapter = MergeAdapter(adapterList)

        binding.rvProductDetail.adapter = mergeAdapter
    }
}
