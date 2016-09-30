package com.example.zhaoxu.lottery.Engine;

import android.util.Xml;

import com.example.zhaoxu.lottery.Bean.UserInfo;
import com.example.zhaoxu.lottery.Contant.ConstantValue;
import com.example.zhaoxu.lottery.Net.protocal.Message;
import com.example.zhaoxu.lottery.Net.protocal.element.UserInfoElement;
import com.example.zhaoxu.lottery.Utils.DES;
import com.example.zhaoxu.lottery.Utils.HttpClientUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/9/27.
 */
public class UserEngineImpl {

    public Message Login(UserInfo userInfo) {
        //create login element and set user data
        UserInfoElement userInfoElement = new UserInfoElement();
        userInfoElement.getActPassword().setTagValue(userInfo.getPassword());
        Message message = new Message();
        message.getHeader().getUsername().setTagValue(userInfo.getUsername());
        String xml = message.getXML(userInfoElement);

        HttpClientUtils httpClientUtils = new HttpClientUtils();
        InputStream is = httpClientUtils.sendXml(ConstantValue.LOTTERY_URI, xml);

        if (is != null) {
            XmlPullParser xmlPullParser = Xml.newPullParser();
            Message result = new Message();
            try {
                xmlPullParser.setInput(is,ConstantValue.ENCONDING);
                int eventType = xmlPullParser.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String name = xmlPullParser.getName();
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            if ("timestamp".equals(name)) {
                                result.getHeader().getTimestamp().setTagValue(xmlPullParser.nextText());
                            }
                            if ("digest".equals(name)) {
                                result.getHeader().getDigest().setTagValue(xmlPullParser.nextText());
                            }
                            if ("body".equals(name)) {
                                result.getBody().setServiceBodyInsideDESInfo(xmlPullParser.nextText());
                            }
                            eventType = xmlPullParser.next();
                            break;
                    }

                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            DES des = new DES();
            String body = "<body>" + des.authcode(result.getBody().getServiceBodyInsideDESInfo(),"ENCODE",ConstantValue.DES_PASSWORD) + "</body>";
            String origin = result.getHeader().getTimestamp().getTagValue() + ConstantValue.AGENTER_PASSWORD;

            String md5Hex = DigestUtils.md5Hex(origin);
            if (md5Hex.equals(result.getHeader().getDigest().getTagValue())) {
                xmlPullParser = Xml.newPullParser();
                try {
                    int bodyType = xmlPullParser.getEventType();
                    while (bodyType != XmlPullParser.END_DOCUMENT) {
                        String bodyName = xmlPullParser.getName();
                        switch (bodyType) {
                            case XmlPullParser.START_TAG:
                                if ("errorcode".equals(bodyName)) {
                                    result.getBody().getOelement().setErrorcode(xmlPullParser.nextText());
                                }
                                if ("errormsg".equals(bodyName)) {
                                    result.getBody().getOelement().setErrormsg(xmlPullParser.nextText());
                                }
                                bodyType = xmlPullParser.next();
                                break;
                        }
                    }
                    return result;
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
