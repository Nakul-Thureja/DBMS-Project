package com.example.bank.ui.Loan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoanViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Loan Fragment"
    }
    val text: LiveData<String> = _text
}