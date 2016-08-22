package com.example.zhaoxu.lottery.Net.protocal;

import android.util.Xml;

import com.example.zhaoxu.lottery.Contant.ConstantValue;
import com.example.zhaoxu.lottery.Utils.DES;

import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public class Body {
    private List<Element> elements = new ArrayList<Element>();

    public List<Element> getElements() {
        return elements;
    }

    public void serializerBody(XmlSerializer serializer) {
        try {
            serializer.startTag(null, "body");
            serializer.startTag(null, "elements");
            for (Element item : elements) {
                item.serializerElement(serializer);
            }
            serializer.endTag(null, "elements");
            serializer.endTag(null, "body");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWholeBody(){
        XmlSerializer temp = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            temp.setOutput(writer);
            serializerBody(temp);
            temp.flush();
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getBodyInsideDESInfo()
    {
        // 鍔犲瘑鏁版嵁
        String wholeBody = getWholeBody();
        String orgDesInfo= StringUtils.substringBetween(wholeBody, "<body>", "</body>");

        // 鍔犲瘑
        // 鍔犲瘑璋冭瘯鈥斺��2澶�
        // 鈶犲姞瀵嗙畻娉曞疄鐜颁笉鍚�
        // 鈶″姞瀵嗙殑鍘熷鏁版嵁涓嶅悓

        DES des=new DES();
        return des.authcode(orgDesInfo, "DECODE", ConstantValue.DES_PASSWORD);
    }
}
