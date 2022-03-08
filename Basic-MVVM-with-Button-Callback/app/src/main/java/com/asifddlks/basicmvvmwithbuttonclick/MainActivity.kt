package com.asifddlks.basicmvvmwithbuttonclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //startActivity(Intent(this,))

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, TestFragment())
            .commit()
    }
}