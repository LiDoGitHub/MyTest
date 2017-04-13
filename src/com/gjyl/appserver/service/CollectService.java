package com.gjyl.appserver.service;

import java.util.List;

import com.gjyl.appserver.pojo.Collect;

public interface CollectService {

	public Boolean collectCycl(Collect collect);

	public Boolean cancleCollect(String userId, String cyclId);

	public Boolean isCollected(String userId, String cyclId);

	public List<Collect> getCollectByUserId(String userId);
}
