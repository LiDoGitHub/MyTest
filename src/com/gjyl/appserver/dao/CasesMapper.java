package com.gjyl.appserver.dao;

import java.util.List;

import com.gjyl.appserver.pojo.Cases;

public interface CasesMapper {
    int deleteByPrimaryKey(String caseid);

    int insert(Cases record);

    int insertSelective(Cases record);

    Cases selectByPrimaryKey(String caseid);

    int updateByPrimaryKeySelective(Cases record);

    int updateByPrimaryKey(Cases record);

    //列表
	List<Cases> getMyCases(String userid);
	//添加
	int addCases(Cases cases);
	//详情
	Cases getCaseInfo(String id);
}