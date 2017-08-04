package com.usher.demo_animation.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.usher.demo_animation.R;

/**
 * Created by UsherChen on 2017/8/4.
 * Details
 */

public class TweenedXmlFragment extends Fragment {

    private Context mContext;
    private View mRootView;
    private ImageView mIvAlpha;
    private ImageView mIvScale;
    private ImageView mIvTranslate;
    private ImageView mIvRotate;
    private ImageView mIvCombine;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_tweened_xml, null);
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
        mIvAlpha.post(new Runnable() {
            @Override
            public void run() {
                Animation alphaAnimation = AnimationUtils.loadAnimation(mContext, R.anim.anim_alpha);
                mIvAlpha.startAnimation(alphaAnimation);
            }
        });
        mIvScale.post(new Runnable() {
            @Override
            public void run() {
                Animation scaleAnimation = AnimationUtils.loadAnimation(mContext, R.anim.anim_scale);
                mIvScale.startAnimation(scaleAnimation);
            }
        });
        mIvTranslate.post(new Runnable() {
            @Override
            public void run() {
                Animation translateAnimation = AnimationUtils.loadAnimation(mContext, R.anim.anim_translate);
                mIvTranslate.startAnimation(translateAnimation);
            }
        });
        mIvRotate.post(new Runnable() {
            @Override
            public void run() {
                Animation rotateAnimation = AnimationUtils.loadAnimation(mContext, R.anim.anim_rotate);
                mIvRotate.startAnimation(rotateAnimation);
            }
        });
        mIvCombine.post(new Runnable() {
            @Override
            public void run() {
                Animation combineAnimation = AnimationUtils.loadAnimation(mContext, R.anim.anim_combine);
                mIvCombine.startAnimation(combineAnimation);
            }
        });
    }
}
