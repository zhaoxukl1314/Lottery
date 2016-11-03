package com.example.zhaoxu.lottery.Activity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaoxu.lottery.Animate.AnimationFactory;
import com.example.zhaoxu.lottery.Net.protocal.Body;
import com.example.zhaoxu.lottery.R;
import com.example.zhaoxu.lottery.View.BaseUI;
import com.example.zhaoxu.lottery.View.FirstUI;
import com.example.zhaoxu.lottery.View.HallView;
import com.example.zhaoxu.lottery.View.SecondUI;
import com.example.zhaoxu.lottery.View.manager.BottomManager;
import com.example.zhaoxu.lottery.View.manager.MiddleManager;
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
        MiddleManager.getInstance().setMiddleLayout(middle);
        MiddleManager.getInstance().addObserver(TitleManager.getInstance());
        MiddleManager.getInstance().addObserver(BottomManager.getInstrance());
//        FirstUI firstUI = new FirstUI(this);
//        middle.addView(firstUI.getChild());
        MiddleManager.getInstance().changeUI(HallView.class);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            boolean isReturn = MiddleManager.getInstance().goBack();
            if (!isReturn) {
                Toast.makeText(this,"exit this program?", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
