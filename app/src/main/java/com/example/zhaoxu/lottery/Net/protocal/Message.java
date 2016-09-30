package com.example.zhaoxu.lottery.Net.protocal;

import android.util.Xml;

import com.example.zhaoxu.lottery.Contant.ConstantValue;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by Administrator on 2016/8/22.
 */
public class Message {

    private Header header = new Header();
    private Body body = new Body();

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }

    public void serializeMessage(XmlSerializer serializer){
        try {
            serializer.startTag(null,"message");
            serializer.attribute(null, "version", "1.0");
            header.serializerHeader(serializer,body.getWholeBody());
            serializer.startTag(null,"body");
            serializer.text(body.getBodyInsideDESInfo());
            serializer.endTag(null,"body");

            serializer.endTag(null,"message");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getXML(Element element){
        if (element == null) {
            throw new IllegalArgumentException("element is null");
        }

        header.getTransactiontype().setTagValue(element.getTransactionType());
        body.getElements().add(element);

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            serializer.setOutput(writer);
            serializer.startDocument(ConstantValue.ENCONDING,null);
            serializeMessage(serializer);
            serializer.endDocument();
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
