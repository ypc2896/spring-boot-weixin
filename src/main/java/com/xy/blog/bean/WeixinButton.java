package com.xy.blog.bean;

import java.util.ArrayList;
import java.util.List;

public class WeixinButton {

    /**
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     */
    private String type;

    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    private String name;

    /**
     * 菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    /**
     * view、miniprogram类型必须	网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url
     */
    private String url;

    /**
     * media_id类型和view_limited类型必须	调用新增永久素材接口返回的合法media_id
     */
    private String media_id;

    /**
     * miniprogram类型必须	小程序的appid（仅认证公众号可配置）
     */
    private String appid;

    /**
     * miniprogram类型必须	小程序的页面路径
     */
    private String pagepath;

    /**
     * 二级菜单数组，个数应为1~5个
     */
    private List<WeixinButton> sub_button;

    public WeixinButton() {}

    public WeixinButton(String type, String name, String key) {
        this.type = type;
        this.name = name;
        this.key = key;
    }

    public WeixinButton(String name, String url){
        this.type = "view";
        this.name = name;
        this.url = url;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public List<WeixinButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<WeixinButton> sub_button) {
        this.sub_button = sub_button;
    }

    public void addSubButton(WeixinButton weixinButton){
        if(this.sub_button == null){
            this.sub_button = new ArrayList<>();
        }
        this.sub_button.add(weixinButton);
    }
}
