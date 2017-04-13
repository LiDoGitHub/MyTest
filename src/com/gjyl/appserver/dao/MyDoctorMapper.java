package com.gjyl.appserver.dao;

import java.util.List;

import com.gjyl.appserver.pojo.MyDoctor;

public interface MyDoctorMapper {
    int deleteByPrimaryKey(String mydrid);

    int insert(MyDoctor record);

    int insertSelective(MyDoctor record);

    MyDoctor selectByPrimaryKey(String mydrid);

    int updateByPrimaryKeySelective(MyDoctor record);

    int updateByPrimaryKey(MyDoctor record);

	List<MyDoctor> getMyDoctor(String userId);

	int addMyDoctor(MyDoctor myDoctor);
	
}