package com.example.prompterapp

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val strings = arrayOf("Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val title = findViewById<TextView>(R.id.title)
//        val reports = findViewById<ListView>(R.id.reportList)
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings)
//
//        reports.adapter = adapter
//        reports.onItemClickListener = OnItemClickListener { parent, v, position, id -> // по позиции получаем выбранный элемент
//            val selectedItem: String = strings[position]
//            // установка текста элемента TextView
//            title.text = selectedItem
//        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
//        val doc1 = findViewById<Button>(R.id.doc1)
//
//        doc1.setOnClickListener{
//
//        }
    }
}