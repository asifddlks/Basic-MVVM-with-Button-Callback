package com.asifddlks.basicmvvmwithbuttonclick

import android.util.Log
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    val callback = object : Callback {
        override fun buttonClicked(view: TestFragment) {
            Log.d("tag","button clicked")
            view.binding.textView.text = view.binding.editText.text.toString()
        }
    }

    public fun setCallback(callback:Callback){

    }

    interface Callback{
        fun buttonClicked(view: TestFragment)
    }
}