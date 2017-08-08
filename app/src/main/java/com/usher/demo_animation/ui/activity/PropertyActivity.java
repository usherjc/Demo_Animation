package com.usher.demo_animation.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.usher.demo_animation.R;

/**
 * Created by UsherChen on 2017/8/5.
 * Details
 */

public class PropertyActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView mCvSimple;
    private TextView mTvSimpleAnim;
    private CardView mCvSimple2;
    private TextView mTvSimpleAnim2;
    private CardView mCvSimple3;
    private TextView mTvSimpleAnim3;
    private ImageView mIvSimpleAnim3;
    private CardView mCvSimple4;
    private TextView mTvSimpleAnim4;
    private View mViewSimpleAnim4;
    private ValueAnimator valueAnimator;
    private int mWidthSimple;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        mCvSimple = (CardView) findViewById(R.id.cv_simple);
        mTvSimpleAnim = (TextView) findViewById(R.id.tv_simple_anim);
        mCvSimple2 = (CardView) findViewById(R.id.cv_simple2);
        mTvSimpleAnim2 = (TextView) findViewById(R.id.tv_simple_anim2);
        mCvSimple3 = (CardView) findViewById(R.id.cv_simple3);
        mTvSimpleAnim3 = (TextView) findViewById(R.id.tv_simple_anim3);
        mIvSimpleAnim3 = (ImageView) findViewById(R.id.iv_simple_anim3);
        mCvSimple4 = (CardView) findViewById(R.id.cv_simple4);
        mTvSimpleAnim4 = (TextView) findViewById(R.id.tv_simple_anim4);
        mViewSimpleAnim4 = findViewById(R.id.view_simple_anim4);
        mCvSimple.setOnClickListener(this);
        mCvSimple.post(new Runnable() {
            @Override
            public void run() {
                mWidthSimple = mCvSimple.getWidth();
            }
        });
        mCvSimple2.setOnClickListener(this);
        mCvSimple3.setOnClickListener(this);
        mCvSimple4.setOnClickListener(this);
    }

    //简单属性动画1
    private void startPropertyAnimator1() {
        mTvSimpleAnim.setVisibility(View.INVISIBLE);
        if (valueAnimator == null) {
            valueAnimator = ValueAnimator.ofInt(0, mWidthSimple);
            valueAnimator.setDuration(1000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int currentValue = (int) animation.getAnimatedValue();
                    mCvSimple.getLayoutParams().width = currentValue;
                    mCvSimple.requestLayout();
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mTvSimpleAnim.setVisibility(View.VISIBLE);
                }
            });
        }
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(4);
        valueAnimator.start();
    }

    //简单属性动画2
    private void startPropertyAnimator2() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTvSimpleAnim2, "alpha", 1f, 0f, 1f);
        objectAnimator.setDuration(1000 * 2);
        objectAnimator.start();
    }

    //简单属性动画3
    private void startPropertyAnimator3() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mIvSimpleAnim3, "rotation", 0f, 360f);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mIvSimpleAnim3.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                mIvSimpleAnim3.setVisibility(View.VISIBLE);
            }
        });
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setRepeatCount(4);
        objectAnimator.start();
    }

    private void startPropertyAnimator4() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mViewSimpleAnim4, "rotationX", 0f, 360f);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mViewSimpleAnim4.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                mViewSimpleAnim4.setVisibility(View.VISIBLE);
            }
        });
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setRepeatCount(4);
        objectAnimator.start();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == mCvSimple.getId()) {
            startPropertyAnimator1();
        }
        if (id == mCvSimple2.getId()) {
            startPropertyAnimator2();
        }
        if (id == mCvSimple3.getId()) {
            startPropertyAnimator3();
        }
        if (id == mCvSimple4.getId()) {
            startPropertyAnimator4();
        }
    }
}
