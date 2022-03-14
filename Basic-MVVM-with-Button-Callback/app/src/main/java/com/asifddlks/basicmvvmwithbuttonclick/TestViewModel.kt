package com.asifddlks.basicmvvmwithbuttonclick

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {

    var sampleData: MutableStateFlow<String> = MutableStateFlow("hello")

    val callback = object : Callback {
        override fun buttonClicked(text: String) {
            Log.d("tag","button clicked")

            viewModelScope.launch{
                sampleData.emit(text)
            }
        }
    }

    public fun setCallback(callback:Callback){

    }

    interface Callback{
        fun buttonClicked(view: String)
    }
}