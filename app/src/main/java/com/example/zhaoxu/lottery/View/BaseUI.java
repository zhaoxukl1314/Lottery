package com.example.zhaoxu.lottery.View;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.zhaoxu.lottery.Net.protocal.Message;
import com.example.zhaoxu.lottery.R;
import com.example.zhaoxu.lottery.Utils.NetUtils;
import com.example.zhaoxu.lottery.Utils.PromptManager;

/**
 * Created by Administrator on 2016/10/13.
 */
public abstract class BaseUI implements View.OnClickListener{
    protected Context mContext;
    protected LinearLayout mMiddleHall;

    public BaseUI(Context mContext) {
        this.mContext = mContext;
        initView();
        setListener();
    }

    protected abstract void initView();

    protected abstract void setListener();

    public View getChild(){
        if (mMiddleHall.getLayoutParams() == null) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            mMiddleHall.setLayoutParams(params);
        }
        return mMiddleHall;
    }

    protected View findViewById(int id) {
        return mMiddleHall.findViewById(id);
    }

    public abstract int getId();

    protected abstract class MyHttpTask<Params> extends
            AsyncTask<Params, Void, Message> {
        /**
         * 类似与Thread.start方法 由于final修饰，无法Override，方法重命名 省略掉网络判断
         *
         * @param params
         * @return
         */
        public final AsyncTask<Params, Void, Message> executeProxy(
                Params... params) {
            if (NetUtils.checkNet(mContext)) {
                return super.execute(params);
            } else {
                PromptManager.showNoNetWork(mContext);
            }
            return null;
        }

    }
}
