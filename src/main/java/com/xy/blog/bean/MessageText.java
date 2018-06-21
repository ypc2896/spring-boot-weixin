package com.xy.blog.bean;

import java.util.Date;

public class MessageText extends BaseMessage {

    private String Content;//文本消息内容

    public MessageText() {

    }


    public MessageText(String toUserName, String fromUserName, String content) {
        super();
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = new Date().getTime();
        MsgType = "text";
        Content = content;
    }


    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
