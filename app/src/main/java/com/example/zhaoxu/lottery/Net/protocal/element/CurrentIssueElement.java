package com.example.zhaoxu.lottery.Net.protocal.element;

import com.example.zhaoxu.lottery.Net.protocal.Element;
import com.example.zhaoxu.lottery.Net.protocal.Leaf;

import org.xmlpull.v1.XmlSerializer;

/**
 * Created by Administrator on 2016/8/22.
 */
public class CurrentIssueElement extends Element {

        // <lotteryid>118</lotteryid>
	private Leaf lotteryid = new Leaf("lotteryid");
    // <issues>1</issues>
	private Leaf issues = new Leaf("issues", "1");

	public Leaf getLotteryid() {
		return lotteryid;
	}

    @Override
    public void serializerElement(XmlSerializer serializer) {
		try {
			serializer.startTag(null, "element");
			lotteryid.serializerLeaf(serializer);
			issues.serializerLeaf(serializer);
			serializer.endTag(null, "element");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public String getTransactionType() {
        return "12002";
    }
}
