package com.usher.demo_animation.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;

import com.usher.demo_animation.R;
import com.usher.demo_animation.ui.fragment.TweenedJavaFragment;
import com.usher.demo_animation.ui.fragment.TweenedXmlFragment;

/**
 * Created by UsherChen on 2017/8/4.
 * Details
 */

public class TweenedActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView mCvXmlType;
    private CardView mCvJavaType;
    private FrameLayout mFlAnim;

    private TweenedXmlFragment mXmlFragment;
    private TweenedJavaFragment mJavaFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweened);
        mCvXmlType = (CardView) findViewById(R.id.cv_xml_type);
        mCvJavaType = (CardView) findViewById(R.id.cv_java_type);
        mFlAnim = (FrameLayout) findViewById(R.id.fl_anim);
        mCvXmlType.setOnClickListener(this);
        mCvJavaType.setOnClickListener(this);
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == mCvXmlType.getId()) {
            if (mXmlFragment == null) {
                mXmlFragment = new TweenedXmlFragment();
            }
            if (!mXmlFragment.isAdded()) {
                mFragmentManager.beginTransaction().replace(mFlAnim.getId(), mXmlFragment).commit();
            }
        }
        if (id == mCvJavaType.getId()) {
            if (mJavaFragment == null) {
                mJavaFragment = new TweenedJavaFragment();
            }
            if (!mJavaFragment.isAdded()) {
                mFragmentManager.beginTransaction().replace(mFlAnim.getId(), mJavaFragment).commit();
            }
        }
    }
}
