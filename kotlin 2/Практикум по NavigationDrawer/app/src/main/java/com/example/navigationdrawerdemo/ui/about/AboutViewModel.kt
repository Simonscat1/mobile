package com.example.navigationdrawerdemo.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel: ViewModel() {
    private val txt =  MutableLiveData<String>().apply {
        value = "This is about page"
    }
    val text: LiveData<String> = txt
}