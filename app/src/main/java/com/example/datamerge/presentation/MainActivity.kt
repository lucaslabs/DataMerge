package com.example.datamerge.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.datamerge.R
import com.example.datamerge.presentation.product_detail.ProductDetailFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProductDetailFragment.newInstance())
                .commitNow()
        }
    }
}