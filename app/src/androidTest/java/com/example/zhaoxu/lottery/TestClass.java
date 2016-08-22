package com.example.zhaoxu.lottery;

import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;
import android.util.Log;

import com.example.zhaoxu.lottery.Net.protocal.Element;
import com.example.zhaoxu.lottery.Net.protocal.Message;
import com.example.zhaoxu.lottery.Net.protocal.element.CurrentIssueElement;

/**
 * Created by Administrator on 2016/8/22.
 */
public class TestClass extends AndroidTestCase {

    private static final String TAG = "TestClass";

    public void test() throws Exception {
        getXml();
    }

    public void getXml() {
        Message message = new Message();
        CurrentIssueElement element = new CurrentIssueElement();
        element.getLotteryid().setTagValue("118");
        String xml = message.getXML(element);
        Log.e(TAG, "zhaoxu xml : " + xml);
    }
}
