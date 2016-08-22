package com.example.zhaoxu.lottery.Net.protocal;

import org.xmlpull.v1.XmlSerializer;

/**
 * Created by Administrator on 2016/8/22.
 */
public abstract class Element {

	abstract public void serializerElement(XmlSerializer serializer);

	abstract public String getTransactionType();
//    // <lotteryid>118</lotteryid>
//	private Leaf lotteryid = new Leaf("lotteryid");
//    // <issues>1</issues>
//	private Leaf issues = new Leaf("issues", "1");
//
//	public Leaf getLotteryid() {
//		return lotteryid;
//	}
//
//	/**
//	 * 搴忓垪鍖栬姹�
//	 */
//	public void serializerElement(XmlSerializer serializer) {
//		try {
//			serializer.startTag(null, "element");
//			lotteryid.serializerLeaf(serializer);
//			issues.serializerLeaf(serializer);
//			serializer.endTag(null, "element");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 鑾峰彇璇锋眰鐨勬爣绀�
//	 */
//	public String getTransactionType() {
//		return "12002";
//	}
}
