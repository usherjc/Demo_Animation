package com.usher.demo_animation.ui.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.usher.demo_animation.R;

/**
 * Created by UsherChen on 2017/8/3.
 * Details 帧动画
 */

public class FrameActivity extends AppCompatActivity {

    private ImageView mIvMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        mIvMain = (ImageView) findViewById(R.id.iv_main);
        mIvMain.setImageResource(R.drawable.emoji_anim);
        final AnimationDrawable animationDrawable = (AnimationDrawable) mIvMain.getDrawable();
        mIvMain.post(new Runnable() {
            @Override
            public void run() {
                animationDrawable.start();
            }
        });
    }
}
