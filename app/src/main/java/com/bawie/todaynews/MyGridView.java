package com.bawie.todaynews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Date：2017/4/12
 * author: 付智焱Administrator.
 * function：
 */

public class MyGridView extends GridView {
    public MyGridView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
