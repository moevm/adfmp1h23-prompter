package com.example.prompterapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val strings = arrayOf("Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aboutButton = findViewById<Button>(R.id.about);
        aboutButton.setOnClickListener {
            val switcher = Intent(this, AboutActivity::class.java)
            this.startActivity(switcher)
        }
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