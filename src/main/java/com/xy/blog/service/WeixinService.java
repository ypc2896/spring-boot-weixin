package com.xy.blog.service;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.xy.blog.bean.MessageValue;
import com.xy.blog.bean.TemplateMessage;
import com.xy.blog.bean.WeixinMenu;
import com.xy.blog.data.MenuData;
import com.xy.blog.rest.ApiService;
import com.xy.blog.rest.RespHandler;
import com.xy.blog.rest.WeixinClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WeixinService {

    public static void main(String... args){

        TemplateMessage templateMessage =
                TemplateMessage.newInstance("oT8_u0wZdPXxmQpfrNs6RqdOVDiU", "wEZOpLezs6m7K1NGhN_xj6ex2U4TCtaeYdJHkm1kyu8")
                        .putData("User", new MessageValue("张慧", "#334959"));
        new WeixinService().sendTemplateMessage(templateMessage);


        //String json = MenuData.getMenuJsonData();
        //new WeixinService().createMenu(json);
    }

    public void createMenu(String json) {
        call("createMenu", json);
    }

    public void createMenu(WeixinMenu menu) {
        call("createMenu", menu);
    }

    public void sendTemplateMessage(TemplateMessage message) {
        call("sendTemplateMessage", message);
    }

    public void call(String methodName, Object obj){

        //使用这个转换，URL会乱码
        //String data = new Gson().toJson(menu);
        GsonBuilder gsonBuilder =new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();
        String json = gsonBuilder.create().toJson(obj);
        System.out.println(json);

        RequestBody body = RequestBody.create(MediaType.parse("application/data; charset=utf-8"),json);

        ApiService service = WeixinClient.createService(ApiService.class);

        try {
            Method method = service.getClass().getMethod(methodName, RequestBody.class);
            Call<JsonObject> call = (Call<JsonObject>) method.invoke(service, body);
            call.enqueue(new RespHandler());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
