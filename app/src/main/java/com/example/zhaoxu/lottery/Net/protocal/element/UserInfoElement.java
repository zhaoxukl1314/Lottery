package com.example.zhaoxu.lottery.Net.protocal.element;

import com.example.zhaoxu.lottery.Net.protocal.Element;
import com.example.zhaoxu.lottery.Net.protocal.Leaf;

import org.xmlpull.v1.XmlSerializer;

/**
 * Created by Administrator on 2016/9/27.
 */
public class UserInfoElement extends Element{

    private Leaf actpassword = new Leaf("actpassword");

    @Override
    public void serializerElement(XmlSerializer serializer) {

    }

    @Override
    public String getTransactionType() {
        return "14001";
    }

    public Leaf getActPassword() {
        return actpassword;
    }
}
