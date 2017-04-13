package com.gjyl.appserver.dao;

import java.util.List;

import com.gjyl.appserver.pojo.Lecture;

public interface LectureMapper {
    int deleteByPrimaryKey(String lecid);

    int insert(Lecture record);

    int insertSelective(Lecture record);

    Lecture selectByPrimaryKey(String lecid);

    int updateByPrimaryKeySelective(Lecture record);

    int updateByPrimaryKey(Lecture record);

    //获取所有
	List<Lecture> getAllLectures();
}