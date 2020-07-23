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
import com.example.datamerge.presentation.product_detail.adapter.*
import com.example.datamerge.presentation.product_detail.viewmodels.ProductOutOfStockViewModel

class ProductDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            ProductDetailFragment()
    }

    private lateinit var binding: ProductDetailFragmentBinding

    // region ViewModels
    private val viewModel: ProductDetailViewModel by viewModels {
        ProductDetailViewModel.ProductDetailViewModelFactory(
            ProductProvider.getProduct()
        )
    }

    private val productOutOfStockViewModel: ProductOutOfStockViewModel by viewModels()
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

        val productGalleryAdapter = ProductGalleryAdapter(productImageAdapter)
        concatAdapter.addAdapter(productGalleryAdapter)

        val productPriceAdapter = ProductPriceAdapter(product)
        concatAdapter.addAdapter(productPriceAdapter)

        productOutOfStockAdapter = ProductOutOfStockAdapter(productOutOfStockViewModel)
        if (product.isOutOfStock) {
            concatAdapter.addAdapter(productOutOfStockAdapter)
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

    private fun setupObservers() {
        productOutOfStockViewModel.notifyMeClicked.observe(viewLifecycleOwner, Observer {
            productOutOfStockViewModel.validateEmail(productOutOfStockAdapter.binding.etEmail.text.toString())
        })

        productOutOfStockViewModel.validateEmail.observe(viewLifecycleOwner,
            Observer { validEmail ->
                if (validEmail) {
                    // We got a valid user email, disable the notify section
                    productOutOfStockAdapter.binding.btnNotify.isEnabled = false
                    productOutOfStockAdapter.binding.etEmail.isEnabled = false
                    val email = productOutOfStockAdapter.binding.etEmail.text.toString()
                    Toast.makeText(
                        activity,
                        "We will notify you at $email", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    productOutOfStockAdapter.binding.etEmail.error = "Please enter a valid email."
                }
            })
    }
}
