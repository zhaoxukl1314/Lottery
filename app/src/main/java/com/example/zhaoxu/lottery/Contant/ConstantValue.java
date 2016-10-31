package com.example.zhaoxu.lottery.Contant;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public interface ConstantValue {
    // class :public static final

    String ENCONDING="UTF-8";
    /**
     * 浠ｇ悊鐨刬d
     */
    String AGENTERID="889931";
//	<source>ivr</source>
    /**
     * 淇℃伅鏉ユ簮
     */
    String SOURCE="ivr";
    //<compress>DES</compress>
    /**
     * body閲岄潰鐨勬暟鎹姞瀵嗙畻娉�
     */
    String COMPRESS="DES";

    /**
     * 瀛愪唬鐞嗗晢鐨勫瘑閽�(.so) JNI
     */
    String AGENTER_PASSWORD = "9ab62a694d8bf6ced1fab6acd48d02f8";

    /**
     * des鍔犲瘑鐢ㄥ瘑閽�
     */
    String DES_PASSWORD = "9b2648fcdfbad80f";
    /**
     * 鏈嶅姟鍣ㄥ湴鍧�
     */
    String LOTTERY_URI = "http://10.0.2.2:8080/ZCWService/Entrance";// 10.0.2.2妯℃嫙鍣ㄥ鏋滈渶瑕佽窡PC鏈洪�氫俊127.0.0.1
    // String LOTTERY_URI = "http://192.168.1.100:8080/ZCWService/Entrance";// 10.0.2.2妯℃嫙鍣ㄥ鏋滈渶瑕佽窡PC鏈洪�氫俊127.0.0.1


    int VIEW_FIRST=1;
    int VIEW_SECOND=2;

    /**
     * 璐僵澶у巺
     */
    int VIEW_HALL=10;
    /**
     * 鍙岃壊鐞冮�夊彿鐣岄潰
     */
    int VIEW_SSQ=15;
    /**
     * 璐墿杞�
     */
    int VIEW_SHOPPING=20;
    /**
     * 杩芥湡鍜屽�嶆姇鐨勮缃晫闈�
     */
    int VIEW_PREBET=25;
    /**
     * 鐢ㄦ埛鐧诲綍
     */
    int VIEW_LOGIN=30;
    /**
     * 鍙岃壊鐞冩爣绀�
     */
    int SSQ=118;
    /**
     * 鏈嶅姟鍣ㄨ繑鍥炴垚鍔熺姸鎬佺爜
     */
    String SUCCESS="0";



    /**
     XmlPullParser parser = Xml.newPullParser();
     try {
     parser.setInput(is, ConstantValue.ENCONDING);

     int eventType = parser.getEventType();
     String name;

     while (eventType != XmlPullParser.END_DOCUMENT) {
     switch (eventType) {
     case XmlPullParser.START_TAG:
     name = parser.getName();
     if ("".equals(name)) {

     }
     break;
     }
     eventType = parser.next();
     }

     } catch (Exception e) {
     e.printStackTrace();
     }
     */

}
