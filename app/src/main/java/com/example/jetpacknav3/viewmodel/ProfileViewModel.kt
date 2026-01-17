package com.example.jetpacknav3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel(): ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    fun changeName(name: String) {
        _name.value = name
    }
}