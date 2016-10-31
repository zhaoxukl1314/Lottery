package com.example.zhaoxu.lottery.View.manager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.zhaoxu.lottery.Animate.AnimationFactory;
import com.example.zhaoxu.lottery.Contant.ConstantValue;
import com.example.zhaoxu.lottery.View.BaseUI;
import com.example.zhaoxu.lottery.View.FirstUI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;

/**
 * Created by zhaoxukl1314 on 16/10/19.
 */

public class MiddleManager extends Observable{

    private static final String TAG = "MiddleManager";
    private static MiddleManager instance = new MiddleManager();
    private RelativeLayout middleLayout;
    private Map<String, BaseUI> mViewCache = new HashMap<String, BaseUI>();
    private LinkedList<String> mHistory = new LinkedList<String>();
    private BaseUI mCurrentUI;

    public void setMiddleLayout(RelativeLayout middleLayout) {
        this.middleLayout = middleLayout;
    }

    private MiddleManager() {

    }

    public static MiddleManager getInstance() {
        return instance;
    }

    public void changeUI(Class<? extends BaseUI> targetClazz) {
        if (mCurrentUI != null && mCurrentUI.getClass() == targetClazz) {
            return;
        }

        String key = targetClazz.getSimpleName();
        BaseUI targetUI = null;
        if (mViewCache.containsKey(key)) {
            targetUI = mViewCache.get(key);
        } else {
            try {
                Constructor<? extends BaseUI> constructor = targetClazz.getConstructor(Context.class);
                targetUI = constructor.newInstance(getContext());
                mViewCache.put(key,targetUI);
            } catch (Exception e) {
                throw new RuntimeException("create constructor failed");
            }
        }

        middleLayout.removeAllViews();
        View childView = targetUI.getChild();
        middleLayout.addView(childView);
        AnimationFactory.fadeIn(childView,0,500);

        mCurrentUI = targetUI;
        mHistory.addFirst(mCurrentUI.getClass().getSimpleName());

        changeTitleAndBottom();
    }

    private void changeTitleAndBottom() {

        switch (mCurrentUI.getId()) {
            case ConstantValue.VIEW_FIRST:
                TitleManager.getInstance().showUnLoginContainer();
                BottomManager.getInstrance().showCommonBottom();
                break;

            case ConstantValue.VIEW_SECOND:
                TitleManager.getInstance().showCommonContainer();
                BottomManager.getInstrance().showGameBottom();
                break;
        }

        setChanged();
        notifyObservers(mCurrentUI.getId());
    }

    private Context getContext() {
        return middleLayout.getContext();
    }

    public boolean goBack() {
        if (mHistory.size() > 0) {
            if (mHistory.size() == 1) {
                return false;
            } else {
                mHistory.removeFirst();
                String key = mHistory.getFirst();
                BaseUI targetUI = mViewCache.get(key);
                changeUI(targetUI.getClass());
                return true;
            }
        }
        return false;
    }
}
