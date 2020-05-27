package com.example.datamerge.binding.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.example.datamerge.R
import com.example.datamerge.databinding.QuantityStepperViewBinding

@BindingMethods(
    BindingMethod(
        type = QuantityStepperView::class,
        attribute = "bind:listener",
        method = "setListener"
    ),
    BindingMethod(
        type = QuantityStepperView::class,
        attribute = "bind:maximumLimit",
        method = "setMaximumLimit"
    ),
    BindingMethod(
        type = QuantityStepperView::class,
        attribute = "bind:minimumLimit",
        method = "setMinimumLimit"
    ),
    BindingMethod(
        type = QuantityStepperView::class,
        attribute = "bind:quantity",
        method = "setQuantity"
    )
)
class QuantityStepperView : FrameLayout, View.OnClickListener {

    interface OnQuantityStepperClickListener {
        fun onIncrementClick(v: View?, quantity: Int)
        fun onDecrementClick(v: View?, quantity: Int)
    }

    private lateinit var binding: QuantityStepperViewBinding
    private lateinit var btnIncrement: ImageButton
    private lateinit var btnDecrement: ImageButton
    private lateinit var tvQuantity: TextView
    private var listener: OnQuantityStepperClickListener? = null
    private var maximumLimit: Int = 0
    private var minimumLimit: Int = 0
    private var quantity: Int = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        binding = QuantityStepperViewBinding.inflate(LayoutInflater.from(context), this, true)
        btnIncrement = binding.btnIncrement
        btnDecrement = binding.btnDecrement
        tvQuantity = binding.tvQuantity

        btnIncrement.setOnClickListener(this)
        btnDecrement.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_increment -> increment(v)
            R.id.btn_decrement -> decrement(v)
        }
    }

    override fun setEnabled(enabled: Boolean) {
        setIncrementButtonEnabled(enabled)
        setDecrementButtonEnabled(enabled)
    }

    private fun setIncrementButtonEnabled(enabled: Boolean) {
        btnIncrement.isEnabled = enabled
        tvQuantity.isEnabled = enabled
    }

    private fun setDecrementButtonEnabled(enabled: Boolean) {
        btnDecrement.isEnabled = enabled
    }

    fun setMinimumLimit(limit: Int) {
        minimumLimit = limit
    }

    fun setMaximumLimit(limit: Int) {
        maximumLimit = limit
    }

    fun setQuantity(qty: Int) {
        quantity = qty
        tvQuantity.text = quantity.toString()

        setIncrementButtonEnabled(true)
        if (quantity >= maximumLimit) {
            setIncrementButtonEnabled(false)
        }
    }

    fun setListener(qtyListener: OnQuantityStepperClickListener) {
        listener = qtyListener
    }

    private fun increment(v: View?) {
        ++quantity
        if (quantity >= maximumLimit) {
            quantity = maximumLimit
            setIncrementButtonEnabled(false)
        } else if (quantity > minimumLimit) {
            setDecrementButtonEnabled(true)
            listener?.onIncrementClick(v, quantity)
        }
        tvQuantity.text = quantity.toString()
    }

    private fun decrement(v: View?) {
        --quantity
        if (quantity < minimumLimit) {
            quantity = 0
        }
        if (quantity < maximumLimit) {
            setIncrementButtonEnabled(true)
            listener?.onDecrementClick(v, quantity)
        }
        tvQuantity.text = quantity.toString()
    }
}