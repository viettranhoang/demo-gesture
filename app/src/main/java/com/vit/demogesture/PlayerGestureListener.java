package com.vit.demogesture;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class PlayerGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean firstTouch;
        private boolean volumeControl;
        private boolean toSeek;

        /**
         * 双击
         */
        @Override
        public boolean onDoubleTap(MotionEvent e) {
//            videoView.toggleAspectRatio();
            return true;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            firstTouch = true;
            return super.onDown(e);

        }

        /**
         * 滑动
         */
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            float mOldX = e1.getX(), mOldY = e1.getY();
            float deltaY = mOldY - e2.getY();
            float deltaX = mOldX - e2.getX();
            if (firstTouch) {
                toSeek = Math.abs(distanceX) >= Math.abs(distanceY);
                volumeControl=mOldX > 1080 * 0.5f;
                firstTouch = false;
            }

            if (toSeek) {
                Log.e("TAG", "onScroll seek: " + -deltaX );
//                if (!isLive) {
//                    onProgressSlide(-deltaX / videoView.getWidth());
//                }
            } else {
//                float percent = deltaY / videoView.getHeight();
                if (volumeControl) {
//                    onVolumeSlide(percent);
                    Log.e("TAG", "onScroll: vol" );
                } else {
//                    onBrightnessSlide(percent);
                    Log.e("TAG", "onScroll: bright" );

                }


            }

            return super.onScroll(e1, e2, distanceX, distanceY);
        }

    /*    @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (isShowing) {
                hide(false);
            } else {
                show(defaultTimeout);
            }
            return true;
        }*/
    }