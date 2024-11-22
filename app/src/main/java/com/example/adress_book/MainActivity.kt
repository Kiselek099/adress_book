package com.example.adress_book

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var personList:MutableList<Person> = mutableListOf()
    lateinit var nameET:EditText
    lateinit var surnameET:EditText
    lateinit var addressET:EditText
    lateinit var numberET:EditText
    lateinit var editBTN:Button
    lateinit var personsLV:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    nameET=findViewById(R.id.nameET)
    surnameET=findViewById(R.id.surmameET)
    addressET=findViewById(R.id.addressET)
    numberET=findViewById(R.id.numberET)
    editBTN=findViewById(R.id.editBTN)
        personsLV=findViewById(R.id.personsLV)
        val adapter=ArrayAdapter<Person>(this,android.R.layout.simple_list_item_1,personList)
        personsLV.adapter=adapter
        editBTN.setOnClickListener {
            if(nameET.text.isEmpty()||surnameET.text.isEmpty()||addressET.text.isEmpty()||numberET.text.isEmpty()) return@setOnClickListener
            val person=Person(nameET.text.toString(),surnameET.text.toString(),addressET.text.toString(),numberET.text.toString())
            personList.add(person)
            adapter.notifyDataSetChanged()
            nameET.text.clear()
            surnameET.text.clear()
            addressET.text.clear()
            numberET.text.clear()
        }
        personsLV.onItemClickListener=
        AdapterView.OnItemClickListener { adapterView, view, position, l ->
            val person=adapter.getItem(position)
            val intent=Intent(this,Information::class.java)
            intent.putExtra(Person::class.java.simpleName,person)
            startActivity(intent)
        }
    }
}