package com.example.datamerge.presentation.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datamerge.R
import com.example.datamerge.data.ProductProvider
import com.example.datamerge.databinding.ProductDetailFragmentBinding
import com.example.datamerge.databinding.ProductOutOfStockItemBinding
import com.example.datamerge.presentation.product_detail.adapter.*
import com.example.datamerge.presentation.product_detail.viewmodels.ProductDescriptionViewModel
import com.example.datamerge.presentation.product_detail.viewmodels.ProductIngredientsViewModel
import com.example.datamerge.presentation.product_detail.viewmodels.ProductOutOfStockViewModel
import com.example.datamerge.presentation.product_detail.viewmodels.ProductPriceViewModel
import com.example.datamerge.presentation.product_detail.viewstates.ProductGalleryViewState

class ProductDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            ProductDetailFragment()
    }

    private lateinit var binding: ProductDetailFragmentBinding

    // region ViewModels
    private val viewModel: ProductDetailViewModel by viewModels {
        ProductDetailViewModel.Factory(ProductProvider.getProduct())
    }
    private val productPriceViewModel: ProductPriceViewModel by viewModels {
        ProductPriceViewModel.Factory(ProductProvider.getProduct())
    }
    private val productOutOfStockViewModel: ProductOutOfStockViewModel by viewModels()
    private val productDescriptionViewModel: ProductDescriptionViewModel by viewModels {
        ProductDescriptionViewModel.Factory(ProductProvider.getProduct())
    }
    private val productIngredientsViewModel: ProductIngredientsViewModel by viewModels {
        ProductIngredientsViewModel.Factory(ProductProvider.getProduct())
    }
    // endregion

    // region Adapters
    private lateinit var productOutOfStockAdapter: ProductOutOfStockAdapter
    // endregion

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
        setupObservers()
    }

    private fun setupAdapters() {
        binding.rvProductDetail.layoutManager = LinearLayoutManager(activity)

        val concatAdapter = ConcatAdapter()

        val product = ProductProvider.getProduct()

        val productImageAdapter = ProductImageAdapter(product.imagesUrl)

        val productGalleryViewState = ProductGalleryViewState(productImageAdapter)
        val productGalleryAdapter = ProductGalleryAdapter(productGalleryViewState)
        concatAdapter.addAdapter(productGalleryAdapter)

        val productPriceAdapter = ProductPriceAdapter(productPriceViewModel)
        concatAdapter.addAdapter(productPriceAdapter)

        productOutOfStockAdapter = ProductOutOfStockAdapter(productOutOfStockViewModel)
        if (product.isOutOfStock) {
            concatAdapter.addAdapter(productOutOfStockAdapter)
        }

        val productDescriptionAdapter = ProductDescriptionAdapter(productDescriptionViewModel)
        concatAdapter.addAdapter(productDescriptionAdapter)

        val productIngredientsAdapter = ProductIngredientsAdapter(productIngredientsViewModel)
        concatAdapter.addAdapter(productIngredientsAdapter)

        binding.rvProductDetail.adapter = concatAdapter
    }

    private fun setupObservers() {
        productOutOfStockViewModel.notifyMeClicked.observe(viewLifecycleOwner, Observer {
            val productOutOfStockBinding =
                productOutOfStockAdapter.binding as ProductOutOfStockItemBinding
            productOutOfStockViewModel.validateEmail(productOutOfStockBinding.etEmail.text.toString())
        })

        productOutOfStockViewModel.validateEmail.observe(viewLifecycleOwner,
            Observer { validEmail ->
                val productOutOfStockBinding =
                    productOutOfStockAdapter.binding as ProductOutOfStockItemBinding
                if (validEmail) {
                    // We got a valid user email, disable the notify section
                    productOutOfStockBinding.btnNotify.isEnabled = false
                    productOutOfStockBinding.etEmail.isEnabled = false
                    val email = productOutOfStockBinding.etEmail.text.toString()
                    Toast.makeText(
                        activity, getString(R.string.notify_email, email), Toast.LENGTH_SHORT
                    ).show()
                } else {
                    productOutOfStockBinding.etEmail.error = getString(R.string.notify_error)
                }
            })
    }
}
