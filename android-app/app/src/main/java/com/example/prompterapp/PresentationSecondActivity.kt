package com.example.prompterapp;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class PresentationSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation_second)
        findViewById<View>(R.id.presentation_2).setOnTouchListener(SwipeListener(this))
    }

    inner class SwipeListener(private val ctx: Context) : OnSwipeTouchListener(ctx) {
        override fun onSwipeRight() {
            super.onSwipeRight()
            val switcher = Intent(ctx, NotesSecondActivity::class.java)
            ctx.startActivity(switcher)
        }

        override fun onSwipeBottom() {
            super.onSwipeBottom()
            val switcher = Intent(ctx, PresentationFirstActivity::class.java)
            ctx.startActivity(switcher)
        }
    }
}
