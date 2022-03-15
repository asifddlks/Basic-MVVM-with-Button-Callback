package com.asifddlks.basicmvvmwithbuttonclick

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {

    var sampleData: MutableStateFlow<String> = MutableStateFlow("hello")
    lateinit var response: Response

    val callback = object : Callback {
        override fun buttonClicked(text: String) {
            Log.d("tag","button clicked")

            viewModelScope.launch{
                sampleData.emit(text)

                delay(3000)
                response.onResponse("This is from response after 3 sec...!!")
            }
        }
    }

    public fun setCallback(callback:Callback){

    }

    public fun setOnResponse(response:Response){
        this.response = response



    }


}