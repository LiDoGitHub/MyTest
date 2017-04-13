package com.gjyl.appserver.dao;

import java.util.List;
import java.util.Map;

import com.gjyl.appserver.pojo.Collect;

public interface CollectMapper {
    int deleteByPrimaryKey(String id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

	int collectCycl(Collect collect);

	int cancleCollect(String userId, String cyclId);

	int isExists(Map<String, String> map);

	List<Collect> getCollectByUserId(String userId);
	
}