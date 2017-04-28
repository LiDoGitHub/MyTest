package com.gjyl.appserver.dao;

import com.gjyl.appserver.pojo.Doctor;

import java.util.List;

public interface DoctorMapper {
    int deleteByPrimaryKey(String doctorid);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(String doctorid);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKeyWithBLOBs(Doctor record);

    List<Doctor> getRandomDr();

	List<Doctor> getDrList();

	Doctor getDrInfo(String doctorid);

	//联想查询用
	List<String> getDocInfoByContent(String content);

	//热搜用
	List<Doctor> getDoctorByContent(String content);

    //Excel导入
    int executeBatch(List<Object> list);
}