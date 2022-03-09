package com.asifddlks.basicmvvmwithbuttonclick

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    var sampleData: MutableLiveData<String> = MutableLiveData<String>("hello")

    val callback = object : Callback {
        override fun buttonClicked(text: String) {
            Log.d("tag","button clicked")
            //view.binding.textView.text = view.binding.editText.text.toString()
            sampleData.value = text
        }
    }

    public fun setCallback(callback:Callback){

    }

    interface Callback{
        fun buttonClicked(view: String)
    }
}