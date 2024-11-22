package com.example.adress_book

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Information : AppCompatActivity() {
    var person:Person? = null
    lateinit var realName:TextView
    lateinit var realSurname:TextView
    lateinit var realAddress:TextView
    lateinit var realNumber:TextView
    lateinit var backBTN:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_information)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    realName=findViewById(R.id.realNameTV)
        realNumber=findViewById(R.id.realNumberTV)
        realSurname=findViewById(R.id.realSurnameTV)
        realAddress=findViewById(R.id.realAddressTV)
        backBTN=findViewById(R.id.backBTN)
        person=intent.extras?.getParcelable(Person::class.java.simpleName) as Person?
        realName.text=person?.name.toString()
        realSurname.text=person?.surname.toString()
        realAddress.text=person?.address.toString()
        realNumber.text=person?.number.toString()

        backBTN.setOnClickListener{
            finish()
        }

    }
}