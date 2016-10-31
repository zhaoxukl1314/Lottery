package com.example.zhaoxu.lottery.Animate;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by zhaoxukl1314 on 16/10/19.
 */

public class AnimationFactory {

    public static void fadeOut(final View view, long offset, long duration) {
        AlphaAnimation fadeOutAnimation = new AlphaAnimation(1,0);
        fadeOutAnimation.setStartOffset(offset);
        fadeOutAnimation.setDuration(duration);
        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ViewGroup parent = (ViewGroup) view.getParent();
                parent.removeView(view);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(fadeOutAnimation);
    }

    public static void fadeIn(final View view, long offset, long duration) {
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0,1);
        fadeInAnimation.setStartOffset(offset);
        fadeInAnimation.setDuration(duration);
        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(fadeInAnimation);
    }
}
