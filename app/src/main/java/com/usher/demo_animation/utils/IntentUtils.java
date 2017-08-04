package com.usher.demo_animation.utils;

import android.content.Context;
import android.content.Intent;

import com.usher.demo_animation.ui.activity.FrameActivity;
import com.usher.demo_animation.ui.activity.TweenedActivity;

/**
 * Created by UsherChen on 2017/8/4.
 * Details
 */

public class IntentUtils {

    public static void toFrameActivity(Context context) {
        Intent intent = new Intent(context, FrameActivity.class);
        context.startActivity(intent);
    }

    public static void toTweenedActivity(Context context) {
        Intent intent = new Intent(context, TweenedActivity.class);
        context.startActivity(intent);
    }

}
