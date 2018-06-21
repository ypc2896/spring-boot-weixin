package com.xy.blog.bean;

import com.thoughtworks.xstream.XStream;

public class BaseMessage {

    protected String ToUserName;
    protected String FromUserName;
    protected long CreateTime;
    protected String MsgType;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String toXml(){
        XStream xstream  = new XStream();
        xstream.alias("xml",this.getClass());
        return xstream.toXML(this);
    }
}
