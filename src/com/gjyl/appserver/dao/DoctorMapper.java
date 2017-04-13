package com.gjyl.appserver.dao;

import java.util.List;

import com.gjyl.appserver.pojo.Doctor;
import com.gjyl.appserver.pojo.DoctorWithBLOBs;

public interface DoctorMapper {
    int deleteByPrimaryKey(String doctorid);

    int insert(DoctorWithBLOBs record);

    int insertSelective(DoctorWithBLOBs record);

    DoctorWithBLOBs selectByPrimaryKey(String doctorid);

    int updateByPrimaryKeySelective(DoctorWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DoctorWithBLOBs record);

    int updateByPrimaryKey(Doctor record);
    
    List<DoctorWithBLOBs> getRandomDr();

	List<DoctorWithBLOBs> getDrList();

	DoctorWithBLOBs getDrInfo(String doctorid);

	//联想查询用
	List<String> getDocInfoByContent(String content);

	//热搜用
	List<Doctor> getDoctorByContent(String content);
	
}