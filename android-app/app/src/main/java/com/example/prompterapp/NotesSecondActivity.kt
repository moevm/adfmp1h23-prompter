package com.example.prompterapp;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class NotesSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_second)
        findViewById<View>(R.id.notes_2).setOnTouchListener(SwipeListener(this))
    }

    inner class SwipeListener(private val ctx: Context) : OnSwipeTouchListener(ctx) {
        override fun onSwipeLeft() {
            super.onSwipeLeft()
            val switcher = Intent(ctx, PresentationSecondActivity::class.java)
            ctx.startActivity(switcher)
        }

        override fun onSwipeBottom() {
            super.onSwipeBottom()
            val switcher = Intent(ctx, NotesFirstActivity::class.java)
            ctx.startActivity(switcher)
        }
    }
}
