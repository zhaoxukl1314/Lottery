package com.example.zhaoxu.lottery.Activity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhaoxu.lottery.Net.protocal.Body;
import com.example.zhaoxu.lottery.R;
import com.example.zhaoxu.lottery.View.BaseUI;
import com.example.zhaoxu.lottery.View.FirstUI;
import com.example.zhaoxu.lottery.View.SecondUI;
import com.example.zhaoxu.lottery.View.manager.BottomManager;
import com.example.zhaoxu.lottery.View.manager.TitleManager;

public class LotteryActivity extends Activity {

    private RelativeLayout middle;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);

        initTitleView();
    }

    private void initTitleView() {
        TitleManager titleManager = TitleManager.getInstance();
        titleManager.initTitle(this);
        titleManager.showCommonContainer();

        BottomManager bottomManager = BottomManager.getInstrance();
        bottomManager.init(this);
        bottomManager.showCommonBottom();

        middle = (RelativeLayout) findViewById(R.id.lottery_middle);
        FirstUI firstUI = new FirstUI(this);
        middle.addView(firstUI.getChild());
    }

    private void ChangeUI(BaseUI ui) {
        middle.removeAllViews();
        View child = ui.getChild();
        middle.addView(child);
    }
}
