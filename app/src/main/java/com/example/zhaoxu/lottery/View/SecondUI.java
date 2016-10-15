package com.example.zhaoxu.lottery.View;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/9.
 */
public class SecondUI {
    private Context mContext;

    public SecondUI(Context context) {
        mContext = context;
    }

    public View getChild() {
        TextView textView = new TextView(mContext);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(layoutParams);
        textView.setText("这是第二个界面");
        textView.setBackgroundColor(Color.BLUE);
        return textView;
    }
}
