package com.example.zhaoxu.lottery.Net.protocal;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

/**
 * Created by Administrator on 2016/8/22.
 */
public class Leaf {
    private String tagName;
    private String tagValue;

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

    public Leaf(String tagName) {
        this.tagName = tagName;
    }

    public Leaf(String tagName, String tagValue) {
        this.tagName = tagName;
        this.tagValue = tagValue;
    }

    public void serializerLeaf(XmlSerializer serializer) {
        try {
            serializer.startTag(null,tagName);
            if (tagValue == null) {
                tagValue = "";
            }
            serializer.text(tagValue);
            serializer.endTag(null,tagName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
