package com.example.datamerge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.datamerge.feature.product.ProductDetailFragment

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