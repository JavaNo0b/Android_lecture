package com.janob.week9_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "자동완성텍스트"

        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setIcon(R.drawable.smile)

        var items = arrayOf("iii-아이", "iii-어른", "iii-젊은이",
            "ill-아이", "ill-젊은이", "arar-아이")

        var auto = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView1)
        var adapter = ArrayAdapter(this,
            android.R.layout.simple_dropdown_item_1line,items)
        auto.setAdapter(adapter)

        var multi = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView1)
        var token = MultiAutoCompleteTextView.CommaTokenizer()
        multi.setTokenizer(token)
        multi.setAdapter(adapter)

    }
}