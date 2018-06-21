package com.xy.blog.data;

import com.xy.blog.bean.WeixinButton;
import com.xy.blog.bean.WeixinMenu;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class MenuData {

    public static String getMenuJsonData(){
        try {
            URI uri = URI.create("file:///Users/xy/Documents/workspace/MyBlog/src/main/resources/weixin_menu.json");
            return IOUtils.toString(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    public static WeixinMenu getMenuBean(){
        List<WeixinButton> buttons = new ArrayList<>();

        String auth = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx08b8a154a945326c&redirect_uri=http://39.105.27.244/index.html&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";

        buttons.add(new WeixinButton("子菜单1-1",auth));
        buttons.add(new WeixinButton("click", "测试子菜单2", "2"));
        buttons.add(new WeixinButton("click", "测试子菜单3", "3"));


        //scope snsapi_base 获取openid, snsapi_userinfo

        /*
        buttons.get(0).addSubButton(new WeixinButton("子菜单1-1",auth));
        buttons.get(0).addSubButton(new WeixinButton("click", "子菜单1-2","12"));
        buttons.get(0).addSubButton(new WeixinButton("click", "子菜单1-3","13"));
        buttons.get(0).addSubButton(new WeixinButton("click", "子菜单1-4","14"));
        buttons.get(0).addSubButton(new WeixinButton("click", "子菜单1-5","15"));
        */
        buttons.get(1).addSubButton(new WeixinButton("click", "子菜单2-1","21"));
        buttons.get(1).addSubButton(new WeixinButton("click", "子菜单2-2","22"));
        buttons.get(1).addSubButton(new WeixinButton("click", "子菜单2-3","23"));
        buttons.get(1).addSubButton(new WeixinButton("click", "子菜单2-4","24"));
        buttons.get(1).addSubButton(new WeixinButton("click", "子菜单2-5","25"));

        buttons.get(2).addSubButton(new WeixinButton("click", "子菜单3-1","31"));
        buttons.get(2).addSubButton(new WeixinButton("click", "子菜单3-2","32"));
        buttons.get(2).addSubButton(new WeixinButton("click", "子菜单3-3","33"));
        buttons.get(2).addSubButton(new WeixinButton("click", "子菜单3-4","34"));
        buttons.get(2).addSubButton(new WeixinButton("click", "子菜单3-5","35"));

        WeixinMenu menu = new WeixinMenu();
        menu.setButton(buttons);
        return menu;
    }

}
