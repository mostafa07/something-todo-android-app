package com.mx3.somethingtodo.ui.common;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GestureListener implements GestureDetector.OnGestureListener {

    private static final String LOG_TAG = GestureListener.class.getSimpleName();

    private static final long VELOCITY_THRESHOLD = 3000;


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1,
                            float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onFling(final MotionEvent motionEvent1, final MotionEvent motionEvent2,
                           final float velocityX, final float velocityY) {

        // if the fling is not fast enough then it's just like drag
        if (Math.abs(velocityX) < VELOCITY_THRESHOLD && Math.abs(velocityY) < VELOCITY_THRESHOLD) {
            return false;
        }

        // if velocity in X direction is higher than velocity in Y direction,
        // then the fling is horizontal, else vertical
        if (Math.abs(velocityX) > Math.abs(velocityY)) {
            if (velocityX >= 0) {
                onSwipeRight();
            } else {
                onSwipeLeft();
            }
        } else {
            if (velocityY >= 0) {
                onSwipeDown();
            } else {
                onSwipeUp();
            }
        }

        return true;
    }


    public void onSwipeRight() {
        Log.i(LOG_TAG, "swipe right");
    }

    public void onSwipeLeft() {
        Log.i(LOG_TAG, "swipe left");
    }

    public void onSwipeUp() {
        Log.i(LOG_TAG, "swipe up");
    }

    public void onSwipeDown() {
        Log.i(LOG_TAG, "swipe down");
    }
}
