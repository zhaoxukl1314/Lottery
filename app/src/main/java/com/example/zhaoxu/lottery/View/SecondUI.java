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
public class SecondUI extends BaseUI{
    private Context mContext;

    public SecondUI(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    public View getChild() {
        TextView textView = new TextView(mContext);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(layoutParams);
        textView.setText("这是第二个界面");
        textView.setBackgroundColor(Color.BLUE);
        return textView;
    }

    @Override
    public int getId() {
        return ConstantValue.VIEW_SECOND;
    }

    @Override
    public void onClick(View v) {

    }
}
