package com.example.zhaoxu.lottery.View;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2016/10/13.
 */
public abstract class BaseUI {
    private Context mContext;

    public BaseUI(Context mContext) {
        this.mContext = mContext;
    }

    public abstract View getChild();
}
