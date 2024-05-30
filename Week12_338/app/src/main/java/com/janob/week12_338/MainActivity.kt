package com.janob.week12_338

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = listOf(1, 2, 3) // List<Int>
        list is List<Number> // OK
        list is List<Int> // OK
        list is List<*> // OK
    }
}