package com.xy.blog.controller;

import com.xy.blog.mapper.MessagePushMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    MessagePushMapper messagePushMapper;

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("name", "张三");

        //List<Map> list =  messagePushMapper.query();
        //map.addAttribute("list", list);

        return "index";
    }

}
