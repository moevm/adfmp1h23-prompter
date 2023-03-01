package com.example.prompterapp

import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import kotlin.math.abs


open class OnSwipeTouchListener(ctx: Context?) : OnTouchListener {
    // Fields:
    /** Whether a swipe motion has been detected  */
    protected var isSwipeDetected = false
    private val gestureDetector: GestureDetector

    // Constructors:
    init {
        gestureDetector = GestureDetector(ctx, GestureListener())
    }

    private inner class GestureListener : SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var result = false
            try {
                val diffY = e2.y - e1.y
                val diffX = e2.x - e1.x
                if (abs(diffX) > abs(diffY)) {    // More of a horizontal movement
                    if (abs(diffX) > constants.HORIZONTAL_SWIPE_THRESHOLD && abs(velocityX) > constants.HORIZONTAL_SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            isSwipeDetected = true
                            onSwipeRight()
                        } else {
                            isSwipeDetected = true
                            onSwipeLeft()
                        }
                    }
                    result = true
                } else {    // Vertical movement
                    if (abs(diffY) > constants.VERTICAL_SWIPE_THRESHOLD && abs(velocityY) > constants.VERTICAL_SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            isSwipeDetected = true
                            onSwipeBottom()
                        } else {
                            isSwipeDetected = true
                            onSwipeTop()
                        }
                    }
                    result = true
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return result
        }

        private val constants = object {
            val HORIZONTAL_SWIPE_THRESHOLD = 0
            val HORIZONTAL_SWIPE_VELOCITY_THRESHOLD = 0
            val VERTICAL_SWIPE_THRESHOLD = 100
            val VERTICAL_SWIPE_VELOCITY_THRESHOLD = 100
        }
    }

    open fun onSwipeRight() {}
    open fun onSwipeLeft() {}
    open fun onSwipeTop() {}
    open fun onSwipeBottom() {}

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event!!)
    }
}