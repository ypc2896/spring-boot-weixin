package com.xy.blog.mapper;


import com.xy.blog.entity.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaMapper {

    @Select("SELECT * FROM bm_area")
    List<Area> getListForPage();

    @Select("SELECT * FROM bm_area WHERE parentid = #{parentId}")
    List<Area> getList(String parentId);

    @Select("SELECT * FROM bm_area WHERE id = #{id}")
    Area getOne(String id);
}
