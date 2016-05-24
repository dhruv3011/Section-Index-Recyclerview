package com.dhruvvaishnav.sectionindexrecyclerviewlib;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;


/**
 * Created by dhruv.vaishnav on 23-05-2016.
 */

public class Utils {

    /**
     * Converts dp to px
     *
     * @param res Resources
     * @param dp  the value in dp
     * @return int
     */
    public static int toPixels(Resources res, float dp) {
        return (int) (dp * res.getDisplayMetrics().density);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean isRtl(Resources res) {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) &&
                (res.getConfiguration().getLayoutDirection() == View.LAYOUT_DIRECTION_RTL);
    }
}