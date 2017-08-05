package com.usher.demo_animation.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.usher.demo_animation.R;

/**
 * Created by UsherChen on 2017/8/4.
 * Details
 */

public class TweenedJavaFragment extends Fragment {

    private Context mContext;
    private View mRootView;

    private ImageView mIvAlpha;
    private ImageView mIvScale;
    private ImageView mIvTranslate;
    private ImageView mIvRotate;
    private ImageView mIvCombine;

    private Animation mAlphaAnimation;
    private Animation mScaleAnimation;
    private Animation mTranslateAnimation;
    private Animation mRotateAnimation;
    private AnimationSet mCombineAnimationSet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_tweened_java, null);
        }
        mContext = getContext();
        mIvAlpha = (ImageView) mRootView.findViewById(R.id.iv_alpha);
        mIvScale = (ImageView) mRootView.findViewById(R.id.iv_scale);
        mIvTranslate = (ImageView) mRootView.findViewById(R.id.iv_translate);
        mIvRotate = (ImageView) mRootView.findViewById(R.id.iv_rotate);
        mIvCombine = (ImageView) mRootView.findViewById(R.id.iv_combine);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAlphaAnimation();
        mIvAlpha.post(new Runnable() {
            @Override
            public void run() {
                mIvAlpha.startAnimation(mAlphaAnimation);
            }
        });
        initScaleAnimation();
        mIvScale.post(new Runnable() {
            @Override
            public void run() {
                mIvScale.startAnimation(mScaleAnimation);
            }
        });
        initTranslateAnimation();
        mIvTranslate.post(new Runnable() {
            @Override
            public void run() {
                mIvTranslate.startAnimation(mTranslateAnimation);
            }
        });
        initRotateAnimation();
        mIvRotate.post(new Runnable() {
            @Override
            public void run() {
                mIvRotate.startAnimation(mRotateAnimation);
            }
        });
        initCombineAnimationSet();
        mIvCombine.post(new Runnable() {
            @Override
            public void run() {
                mIvCombine.startAnimation(mCombineAnimationSet);
            }
        });
    }

    private void initAlphaAnimation() {
        mAlphaAnimation = new AlphaAnimation(1f, 0f);
        mAlphaAnimation.setDuration(1000);
        mAlphaAnimation.setRepeatCount(Animation.INFINITE);
        mAlphaAnimation.setRepeatMode(Animation.REVERSE);
        mAlphaAnimation.setFillAfter(true);
    }

    private void initScaleAnimation() {
        mScaleAnimation = new ScaleAnimation(
                0.5f, 1f,
                0.5f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        mScaleAnimation.setDuration(1000);
        mScaleAnimation.setRepeatCount(Animation.INFINITE);
        mScaleAnimation.setRepeatMode(Animation.REVERSE);
        mScaleAnimation.setFillAfter(true);
    }

    private void initTranslateAnimation() {
        mTranslateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, -1f,
                Animation.RELATIVE_TO_SELF, 1f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f);
        mTranslateAnimation.setDuration(1000);
        mTranslateAnimation.setRepeatCount(Animation.INFINITE);
        mTranslateAnimation.setRepeatMode(Animation.REVERSE);
        mTranslateAnimation.setFillAfter(true);
    }

    private void initRotateAnimation() {
        mRotateAnimation = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        mRotateAnimation.setDuration(1000);
        mRotateAnimation.setRepeatCount(Animation.INFINITE);
        mRotateAnimation.setRepeatMode(Animation.REVERSE);
        mRotateAnimation.setFillAfter(true);
    }

    private void initCombineAnimationSet() {
        mCombineAnimationSet = new AnimationSet(false);
        mCombineAnimationSet.addAnimation(mAlphaAnimation);
        mCombineAnimationSet.addAnimation(mScaleAnimation);
        mCombineAnimationSet.addAnimation(mTranslateAnimation);
    }

}
