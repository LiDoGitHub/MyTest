package com.gjyl.appserver.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.CollectMapper;
import com.gjyl.appserver.pojo.Collect;
import com.gjyl.appserver.service.CollectService;

@Service("collectService")
public class CollectServiceImpl implements CollectService {

	@Resource
	private CollectMapper mapper;

	public Boolean collectCycl(Collect collect) {
		int result= mapper.collectCycl(collect);
		if (result>0) {
			return true;
		}else {
			return false;
		}
	}

	public Boolean cancleCollect(String userId, String cyclId) {
		
		int result = mapper.cancleCollect(userId,cyclId);
		if (result>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean isCollected(String userId, String cyclId){
		Map<String, String>map=new HashMap<String, String>();
		map.put("userId", userId);
		map.put("cyclId", cyclId);
		int result = mapper.isExists(map);
		if (result>0) {
			return true;
		}
		return false;
	}

	public List<Collect> getCollectByUserId(String userId) {

		return mapper.getCollectByUserId(userId);
	}
	
}
