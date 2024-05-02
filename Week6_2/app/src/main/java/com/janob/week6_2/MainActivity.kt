package com.janob.week6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var text1: TextView
    lateinit var text2: TextView
    lateinit var chkAgree: CheckBox
    lateinit var rGroup1: RadioGroup
    lateinit var rdoDog: RadioButton
    lateinit var rdoRabbit: RadioButton
    lateinit var rdoCat: RadioButton
    lateinit var rdoHorse: RadioButton
    lateinit var rdoHam: RadioButton
    lateinit var btnOk: Button
    lateinit var imgPet: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "애완동물 사진 보기"

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.androidlogo)


        text1 = findViewById<TextView>(R.id.Text1)
        chkAgree = findViewById<CheckBox>(R.id.ChkAgree)

        text2 = findViewById<TextView>(R.id.Text2)
        rGroup1 = findViewById<RadioGroup>(R.id.RGroup1)
        rdoDog = findViewById<RadioButton>(R.id.RdoDog)
        rdoRabbit = findViewById<RadioButton>(R.id.RdoRabbit)
        rdoCat = findViewById<RadioButton>(R.id.RdoCat)
        rdoHorse = findViewById<RadioButton>(R.id.RdoHorse)
        rdoHam = findViewById<RadioButton>(R.id.RdoHam)

        btnOk = findViewById<Button>(R.id.BtnOk)
        imgPet = findViewById<ImageView>(R.id.ImgPet)

        chkAgree.setOnCheckedChangeListener{ compoundButton, b ->

            if(chkAgree.isChecked == true){
                text2.visibility = View.VISIBLE
                rGroup1.visibility = View.VISIBLE
                btnOk.visibility = View.VISIBLE
                imgPet.visibility = View.VISIBLE
            }else{
                text2.visibility = View.INVISIBLE
                rGroup1.visibility = View.INVISIBLE
                btnOk.visibility = View.INVISIBLE
                imgPet.visibility = View.INVISIBLE
            }
        }
        btnOk.setOnClickListener {
            when(rGroup1.checkedRadioButtonId){
                R.id.RdoDog -> imgPet.setImageResource(R.drawable.images)
                R.id.RdoRabbit -> imgPet.setImageResource(R.drawable.images2)
                R.id.RdoCat -> imgPet.setImageResource(R.drawable.images3)
                R.id.RdoHorse -> imgPet.setImageResource(R.drawable.images4)
                R.id.RdoHam -> imgPet.setImageResource(R.drawable.images5)
                else -> Toast.makeText(applicationContext, "동물 먼저 선택하세요.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}