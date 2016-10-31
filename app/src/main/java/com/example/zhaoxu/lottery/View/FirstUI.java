package com.example.zhaoxu.lottery.View;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhaoxu.lottery.Contant.ConstantValue;

/**
 * Created by Administrator on 2016/10/9.
 */
public class FirstUI extends BaseUI{

    private Context mContext;

    public FirstUI(Context context) {
        super(context);
        mContext = context;
    }

    public View getChild() {
        TextView textView = new TextView(mContext);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(layoutParams);
        textView.setText("这是第一个界面");
        textView.setBackgroundColor(Color.RED);
        return textView;
    }

    @Override
    public int getId() {
        return ConstantValue.VIEW_FIRST;
    }
}
