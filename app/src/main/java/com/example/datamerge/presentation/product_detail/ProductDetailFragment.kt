package com.example.datamerge.presentation.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datamerge.R
import com.example.datamerge.data.ProductProvider
import com.example.datamerge.databinding.ProductDetailFragmentBinding
import com.example.datamerge.presentation.product_detail.adapter.*

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
            inflater, R.layout.product_detail_fragment, container, false
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

        val concatAdapter = ConcatAdapter()

        val product = ProductProvider.getProduct()

        val productImageAdapter = ProductImageAdapter(product.imagesUrl)

        val productGalleryAdapter = ProductGalleryAdapter(productImageAdapter)
        concatAdapter.addAdapter(productGalleryAdapter)

        val productPriceAdapter = ProductPriceAdapter(product)
        concatAdapter.addAdapter(productPriceAdapter)

        if (product.isOutOfStock) {
            concatAdapter.addAdapter(ProductOutOfStockAdapter())
        }

        val productDescriptionAdapter = ProductDescriptionAdapter(
            getString(R.string.product_description_title),
            product.description
        )
        concatAdapter.addAdapter(productDescriptionAdapter)

        val productIngredientsAdapter = ProductDescriptionAdapter(
            getString(R.string.product_ingredients_title),
            product.ingredients
        )
        concatAdapter.addAdapter(productIngredientsAdapter)

        binding.rvProductDetail.adapter = concatAdapter
    }
}
