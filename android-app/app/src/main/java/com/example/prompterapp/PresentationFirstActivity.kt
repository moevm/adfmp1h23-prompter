package com.example.prompterapp;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class PresentationFirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation_first)
        findViewById<View>(R.id.presentation_1).setOnTouchListener(SwipeListener(this))
    }

    inner class SwipeListener(private val ctx: Context) : OnSwipeTouchListener(ctx) {
        override fun onSwipeRight() {
            super.onSwipeRight()
            val switcher = Intent(ctx, NotesFirstActivity::class.java)
            ctx.startActivity(switcher)
        }

        override fun onSwipeTop() {
            super.onSwipeTop()
            val switcher = Intent(ctx, PresentationSecondActivity::class.java)
            ctx.startActivity(switcher)
        }
    }
}
