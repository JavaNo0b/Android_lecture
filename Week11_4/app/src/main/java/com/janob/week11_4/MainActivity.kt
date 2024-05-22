package com.janob.week11_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            var items = arrayOf("제육볶음", "돈까스", "순대국밥")
            var selectedItem: String? = null
            
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("좋아하는 음식은?")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setSingleChoiceItems(items,-1) {dialog, which ->
                selectedItem = items[which]
            }


            dlg.setPositiveButton("닫기", null)
            dlg.show()
        }
    }
}