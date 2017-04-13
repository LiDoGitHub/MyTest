package com.gjyl.appserver.dao;

import com.gjyl.appserver.pojo.Essay;

public interface EssayMapper {
    int deleteByPrimaryKey(String eid);

    int insert(Essay record);

    int insertSelective(Essay record);

    Essay selectByPrimaryKey(String eid);

    int updateByPrimaryKeySelective(Essay record);

    int updateByPrimaryKey(Essay record);
}