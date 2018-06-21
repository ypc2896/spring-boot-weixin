package com.xy.blog.controller;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xy.blog.bean.MessageText;
import com.xy.blog.rest.ApiService;
import com.xy.blog.rest.WeixinClient;
import com.xy.blog.util.CheckUtil;
import com.xy.blog.util.MessageUtil;
import com.xy.blog.util.MyConst;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/weixin")
public class WeiXinController {

    @GetMapping("/")
    public void checkSign(HttpServletRequest request, HttpServletResponse response){

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            if(CheckUtil.checkSignature(signature, timestamp, nonce)){
                out.write(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
    }

    @PostMapping("/")
    public String process(HttpServletRequest request) {

        // 将解析结果存储在HashMap中
        Map<String, String> map = MessageUtil.xmlToMap(request);
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String msgType = map.get("MsgType");
        String content = map.get("Content");

        String msg = "";

        if("event".equals(msgType)){
            msg = "欢迎关注本测试公众号，这是一条测试数据";
        }else if("text".equals(msgType)){
            msg = "这还是一条测试数据: " + content;
        }

        MessageText message = new MessageText(fromUserName, toUserName, msg);
        return message.toXml();
    }

    @PostMapping("/openid")
    public Map getOpenId(@RequestBody String body){
        JsonObject json = new Gson().fromJson(body, JsonObject.class);

        String code = json.has("code") ? json.get("code").getAsString() : "";

        Map<String,String> params = new HashMap<>();
        params.put("appid", MyConst.AppID);
        params.put("secret", MyConst.appsecret);
        params.put("code", code);
        params.put("grant_type", "authorization_code");


        try {
            Response<JsonObject> response = WeixinClient.createService(ApiService.class)
                    .getOpenId(params)
                    .execute();

            Map map = new Gson().fromJson(response.body(), Map.class);
            System.out.println(map);
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
