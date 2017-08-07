package com.usher.demo_animation.ui.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.usher.demo_animation.R;

/**
 * Created by UsherChen on 2017/8/5.
 * Details
 */

public class PropertyActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView mCvSimple;
    private TextView mTvSimpleAnim;
    private CardView mCvComplicate;
    private ValueAnimator valueAnimator;
    private int mWidthSimple;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        mCvSimple = (CardView) findViewById(R.id.cv_simple);
        mTvSimpleAnim = (TextView) findViewById(R.id.tv_simple_anim);
        mCvComplicate = (CardView) findViewById(R.id.cv_complicate);
        mCvSimple.setOnClickListener(this);
        mCvSimple.post(new Runnable() {
            @Override
            public void run() {
                mWidthSimple = mCvSimple.getWidth();
            }
        });
    }

    //手动赋值给对象属性
    private void startPropertyAnimator() {
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
                    if (currentValue == mWidthSimple) {
                        mTvSimpleAnim.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
        valueAnimator.start();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == mCvSimple.getId()) {
            startPropertyAnimator();
        }
    }
}
