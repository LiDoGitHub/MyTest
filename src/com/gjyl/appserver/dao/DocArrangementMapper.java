package com.gjyl.appserver.dao;

import com.gjyl.appserver.pojo.DocArrangement;

import java.util.List;

public interface DocArrangementMapper {
    int deleteByPrimaryKey(String arrid);

    int insert(DocArrangement record);

    //新增
    int insertSelective(DocArrangement record);

    //查询
    DocArrangement selectByPrimaryKey(String arrid);

    int updateByPrimaryKeySelective(DocArrangement record);

    int updateByPrimaryKey(DocArrangement record);

    //排班列表
    List<DocArrangement> getArrangeList();

    //查询
    DocArrangement getArrangeByDocId(String docId);
}