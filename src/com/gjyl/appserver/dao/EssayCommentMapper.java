package com.gjyl.appserver.dao;

import com.gjyl.appserver.pojo.EssayComment;

public interface EssayCommentMapper {
    int deleteByPrimaryKey(String ecid);

    int insert(EssayComment record);

    int insertSelective(EssayComment record);

    EssayComment selectByPrimaryKey(String ecid);

    int updateByPrimaryKeySelective(EssayComment record);

    int updateByPrimaryKey(EssayComment record);
}