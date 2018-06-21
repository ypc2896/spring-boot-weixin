package com.xy.blog.bean;

import java.util.HashMap;
import java.util.Map;

public class TemplateMessage {

    private String touser;
    private String template_id;
    private String url;
    private String topcolor;
    private Map<String, MessageValue> data;

    private TemplateMessage() { }

    public static TemplateMessage newInstance(String touser, String template_id){
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.touser = touser;
        templateMessage.template_id = template_id;
        return templateMessage;
    }

    public String getTouser() {
        return touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public String getUrl() {
        return url;
    }

    public TemplateMessage setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public TemplateMessage setTopcolor(String topcolor) {
        this.topcolor = topcolor;
        return this;
    }

    public Map<String, MessageValue> getData() {
        return data;
    }

    public TemplateMessage setData(Map<String, MessageValue> data) {
        this.data = data;
        return this;
    }

    public TemplateMessage putData(String key, MessageValue item){
        if(this.data == null){
            this.data = new HashMap();
        }
        this.data.put(key,item);
        return this;
    }

}
