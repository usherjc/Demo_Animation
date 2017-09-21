package com.usher.demo_animation.ui.test1;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ScrollView;

import com.usher.demo_animation.R;

/**
 * Created by USHER on 2017/9/21.
 */

@RequiresApi(api = Build.VERSION_CODES.M)
public class Scroll4AnimationActivity extends AppCompatActivity implements View.OnScrollChangeListener {

    private ScrollView mSvMain;
    private CardView mCvSimple;
    private int mWidthOrigin;//初始长度

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_4_animation);
        initView();
        mSvMain.setOnScrollChangeListener(this);
        mCvSimple.post(new Runnable() {
            @Override
            public void run() {
                mWidthOrigin = mCvSimple.getWidth();
            }
        });
    }

    private void initView() {
        mSvMain = (ScrollView) findViewById(R.id.sv_main);
        mCvSimple = (CardView) findViewById(R.id.cv_simple);
    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        int width;
        if (scrollY - oldScrollY > 0) {
            if (200 - scrollY > 0) {
                width = mWidthOrigin - scrollY;
            } else {
                width = mWidthOrigin - 200;
            }
        } else {
            if (scrollY > 200) {
                width = mWidthOrigin - 200;
            } else {
                width = mWidthOrigin - scrollY;
            }
        }
        mCvSimple.getLayoutParams().width = width;
        mCvSimple.requestLayout();
    }
}
