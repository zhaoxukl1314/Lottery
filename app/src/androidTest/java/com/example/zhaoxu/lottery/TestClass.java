package com.example.zhaoxu.lottery;

import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;
import android.util.Log;

import com.example.zhaoxu.lottery.Bean.UserInfo;
import com.example.zhaoxu.lottery.Engine.UserEngineImpl;
import com.example.zhaoxu.lottery.Net.protocal.Element;
import com.example.zhaoxu.lottery.Net.protocal.Message;
import com.example.zhaoxu.lottery.Net.protocal.element.CurrentIssueElement;

/**
 * Created by Administrator on 2016/8/22.
 */
public class TestClass extends AndroidTestCase {

    private static final String TAG = "TestClass";

    public void test() throws Exception {
        testLogin();
    }

    public void getXml() {
        Message message = new Message();
        CurrentIssueElement element = new CurrentIssueElement();
        element.getLotteryid().setTagValue("118");
        String xml = message.getXML(element);
        Log.e(TAG, "zhaoxu xml : " + xml);
    }

    public void testLogin() {
        UserEngineImpl userEngine = new UserEngineImpl();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhaoxu");
        userInfo.setPassword("hahahahahaha");
        Message login = userEngine.Login(userInfo);
        Log.d(TAG,"errorCode" + login.getBody().getOelement().getErrorcode());
    }

}
