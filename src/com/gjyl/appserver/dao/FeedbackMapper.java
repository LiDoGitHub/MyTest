package com.gjyl.appserver.dao;

import com.gjyl.appserver.pojo.Feedback;

public interface FeedbackMapper {
    int deleteByPrimaryKey(String feedid);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(String feedid);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}