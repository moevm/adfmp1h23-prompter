package com.example.prompterapp;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity



class NotesFirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_first)
        findViewById<View>(R.id.notes_1).setOnTouchListener(SwipeListener(this))
    }

    inner class SwipeListener(private val ctx: Context) : OnSwipeTouchListener(ctx) {
        override fun onSwipeLeft() {
            super.onSwipeLeft()
            val switcher = Intent(ctx, PresentationFirstActivity::class.java)
            ctx.startActivity(switcher)
        }

        override fun onSwipeTop() {
            super.onSwipeTop()
            val switcher = Intent(ctx, NotesSecondActivity::class.java)
            ctx.startActivity(switcher)
        }
    }
}
