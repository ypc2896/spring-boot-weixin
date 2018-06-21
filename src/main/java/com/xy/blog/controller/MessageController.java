package com.xy.blog.controller;

import com.xy.blog.core.Result;
import com.xy.blog.core.ResultGenerator;
import com.xy.blog.entity.MessagePush;
import com.xy.blog.mapper.MessagePushMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessagePushMapper messagePushMapper;

    @PostMapping("/insert")
    public Result insert(@RequestBody  MessagePush messagePush){
        try{
            messagePushMapper.insert(messagePush);
        }catch (Exception e){
            return ResultGenerator.genFailResult(e.getMessage());
        }

        return ResultGenerator.genSuccessResult();
    }



}
