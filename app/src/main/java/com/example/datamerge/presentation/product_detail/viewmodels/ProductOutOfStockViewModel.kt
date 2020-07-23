package com.example.datamerge.presentation.product_detail.viewmodels

import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.datamerge.R
import com.example.datamerge.presentation.base.BaseViewModel
import com.example.datamerge.presentation.utils.EmailValidator

class ProductOutOfStockViewModel : BaseViewModel(), View.OnClickListener {

    private val _notifyMeClicked = MutableLiveData<Unit>()
    val notifyMeClicked: LiveData<Unit> = _notifyMeClicked

    private val _validateEmail = MutableLiveData<Boolean>()
    val validateEmail: LiveData<Boolean> = _validateEmail

    @Bindable
    var notifyText = R.string.notify_product_in_stock

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_notify -> _notifyMeClicked.value = Unit
        }
    }

    fun validateEmail(email: String?) {
        if (email.isNullOrEmpty()) {
            _validateEmail.value = false
        } else {
            _validateEmail.value = EmailValidator.isValidEmail(email)
        }
    }
}