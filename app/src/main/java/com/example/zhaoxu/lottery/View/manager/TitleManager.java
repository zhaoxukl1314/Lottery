package com.example.zhaoxu.lottery.View.manager;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhaoxu.lottery.R;

/**
 * Created by Administrator on 2016/10/7.
 */
public class TitleManager {

    private static TitleManager instance;

    private TitleManager() {
        //NOP
    }

    public static TitleManager getInstance() {
        if (instance == null) {
            instance = new TitleManager();
        }
        return instance;
    }

    private RelativeLayout commonContainer;
    private RelativeLayout loginContainer;
    private RelativeLayout unLoginContainer;

    private ImageView goback;// 返回
    private ImageView help;// 帮助
    private ImageView login;// 登录

    private TextView titleContent;// 标题内容
    private TextView userInfo;// 用户信息

    public void initTitle(Activity activity) {
        commonContainer = (RelativeLayout) activity.findViewById(R.id.top_common_container);
        unLoginContainer = (RelativeLayout) activity.findViewById(R.id.unLoginTitle);
        loginContainer = (RelativeLayout) activity.findViewById(R.id.top_login_title);

        goback = (ImageView) activity.findViewById(R.id.top_left_icon_goback);
        help = (ImageView) activity.findViewById(R.id.top_right_icon_help);
        login = (ImageView) activity.findViewById(R.id.top_middle_login);

        titleContent = (TextView) activity.findViewById(R.id.top_middle_text);
        userInfo = (TextView) activity.findViewById(R.id.top_user_info);

        setListener();
    }

    private void init() {
        commonContainer.setVisibility(View.GONE);
        unLoginContainer.setVisibility(View.GONE);
        loginContainer.setVisibility(View.GONE);
    }

    private void setListener() {
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void showCommonContainer() {
        init();
        commonContainer.setVisibility(View.VISIBLE);
    }

    public void showUnLoginContainer() {
        init();
        unLoginContainer.setVisibility(View.VISIBLE);
    }

    public void showLoginContainer() {
        init();
        loginContainer.setVisibility(View.VISIBLE);
    }

    public void changeTitle(String titleText) {
        titleContent.setText(titleText);
    }
}
