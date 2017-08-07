package com.usher.demo_animation.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.usher.demo_animation.R;
import com.usher.demo_animation.utils.IntentUtils;

/**
 * Created by UsherChen on 2017/8/3.
 * Details
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView mCvFrameAnim;
    private CardView mCvTweenedAnim;
    private CardView mCvPropertyAnim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCvFrameAnim = (CardView) findViewById(R.id.cv_frame_anim);
        mCvTweenedAnim = (CardView) findViewById(R.id.cv_tweened_anim);
        mCvPropertyAnim = (CardView) findViewById(R.id.cv_property_anim);
        mCvFrameAnim.setOnClickListener(this);
        mCvTweenedAnim.setOnClickListener(this);
        mCvPropertyAnim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == mCvFrameAnim.getId()) {
            IntentUtils.toFrameActivity(this);
        }
        if (id == mCvTweenedAnim.getId()) {
            IntentUtils.toTweenedActivity(this);
        }
        if (id == mCvPropertyAnim.getId()) {
            IntentUtils.toPropertyActivity(this);
        }
    }
}
