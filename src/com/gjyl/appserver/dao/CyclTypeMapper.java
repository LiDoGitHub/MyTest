package com.gjyl.appserver.dao;

import java.util.List;

import com.gjyl.appserver.pojo.CyclType;

public interface CyclTypeMapper {
    int deleteByPrimaryKey(String typeid);

    int insert(CyclType record);

    int insertSelective(CyclType record);

    CyclType selectByPrimaryKey(String typeid);

    int updateByPrimaryKeySelective(CyclType record);

    int updateByPrimaryKey(CyclType record);

	List<CyclType> getAllTypes();
}