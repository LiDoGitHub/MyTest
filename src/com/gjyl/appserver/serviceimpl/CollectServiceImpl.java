package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.CollectMapper;
import com.gjyl.appserver.pojo.Collect;
import com.gjyl.appserver.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String,String> map=new HashMap<>();
		map.put("userid",userId);
		map.put("cyclId",cyclId);
		int result = mapper.cancleCollect(map);
		if (result>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean isCollected(String userId, String cyclId){
		Map<String, String>map= new HashMap<>();
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
