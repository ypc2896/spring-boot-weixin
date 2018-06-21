package com.xy.blog.mapper;

import com.xy.blog.entity.MessagePush;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MessagePushMapper {

    @Insert("INSERT INTO message_push_record (hosid, duid, dname, dtitle, dtype, " +
            "puuid, title, description, content, msgtype, submsgtype, touid, " +
            "tousername, toutype, patientperiod, receivestatus, puid) " +
            "VALUE  ( #{hosid}, #{duid}, #{dname}, #{dtitle}, #{dtype}, #{puuid}, #{title}, #{description}, " +
            "#{content}, #{msgtype}, #{submsgtype}, #{touid}, #{tousername}, #{toutype}, #{patientperiod}," +
            " #{receivestatus}, #{puid})")
    void insert(MessagePush messagePush);


    @Select("SELECT duid, dname, deptid, deptname,count(*),sum(zy), sum(cy), sum(mz)\n" +
            "FROM (\n" +
            "  select a.duid, dname,deptid, deptname,\n" +
            "  case when patientperiod = '在院' THEN  1 ELSE 0 END as zy,\n" +
            "  case when patientperiod = '出院' THEN  1 ELSE 0 END as cy,\n" +
            "  case when patientperiod = '门诊' THEN  1 ELSE 0 END as mz\n" +
            "  from msg_push_record a, doctors b\n" +
            " where a.duid = b.duid\n" +
            "   and msgtype = 1\n" +
            "   and pubtime >= '2018-01-01'\n" +
            "   and pubtime < '2018-02-01') as b\n" +
            "GROUP BY duid, dname, deptid, deptname\n" +
            "ORDER BY duid;")
    List<Map> query();


}
