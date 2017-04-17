package com.gjyl.appserver.dao;

import com.gjyl.appserver.pojo.DocArrangement;

public interface DocArrangementMapper {
    int deleteByPrimaryKey(String arrid);

    int insert(DocArrangement record);

    int insertSelective(DocArrangement record);

    DocArrangement selectByPrimaryKey(String arrid);

    int updateByPrimaryKeySelective(DocArrangement record);

    int updateByPrimaryKey(DocArrangement record);
}