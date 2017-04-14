package com.gjyl.appserver.dao;

import com.gjyl.appserver.pojo.EssayAgree;

import java.util.Map;

public interface EssayAgreeMapper {
    int deleteByPrimaryKey(String agreeid);

    int insert(EssayAgree record);

    //增加点赞用户
    int insertSelective(EssayAgree record);

    EssayAgree selectByPrimaryKey(String agreeid);

    int updateByPrimaryKeySelective(EssayAgree record);

    int updateByPrimaryKey(EssayAgree record);

    //取消点赞
    int disAgreeWithEssay(Map<String, String> map);
}