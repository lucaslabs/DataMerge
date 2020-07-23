package com.example.datamerge.presentation.utils

object EmailValidator {

    fun isValidEmail(email: String) =
        android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}