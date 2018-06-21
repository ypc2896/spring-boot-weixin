package com.xy.blog.controller;

import com.github.pagehelper.PageHelper;
import com.xy.blog.core.Result;
import com.xy.blog.core.ResultGenerator;
import com.xy.blog.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private AreaMapper areaMapper;

    @RequestMapping("getListForPage")
    public Result getListForPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(areaMapper.getListForPage());
    }

    @RequestMapping("/hello")
    public Result hello(String id){
        return ResultGenerator.genSuccessResult(areaMapper.getOne(id));
    }

    @RequestMapping("/getList")
    public Result getList(String parentid){
        return ResultGenerator.genSuccessResult(areaMapper.getList(parentid));
    }

}
