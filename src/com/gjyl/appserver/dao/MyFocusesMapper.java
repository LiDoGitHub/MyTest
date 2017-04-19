package com.gjyl.appserver.dao;

import com.gjyl.appserver.pojo.MyFocuses;

import java.util.Map;

public interface MyFocusesMapper {
    int deleteByPrimaryKey(String focusid);

    int insert(MyFocuses record);

    int insertSelective(MyFocuses record);

    MyFocuses selectByPrimaryKey(String focusid);

    int updateByPrimaryKeySelective(MyFocuses record);

    int updateByPrimaryKey(MyFocuses record);

    //是否关注
    int isExist(Map<String, String> map);
}