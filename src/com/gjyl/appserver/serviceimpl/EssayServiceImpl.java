package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.EssayAgreeMapper;
import com.gjyl.appserver.dao.EssayMapper;
import com.gjyl.appserver.pojo.Essay;
import com.gjyl.appserver.pojo.EssayAgree;
import com.gjyl.appserver.service.EssayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("essayService")
public class EssayServiceImpl implements EssayService {

	@Resource
	private EssayMapper dao;
	@Resource
	private EssayAgreeMapper eaDao;

	public Boolean publishEssay(Essay essay) {

		int rst=dao.publishEssay(essay);

		if (rst>0){
			return true;
		}
		return false;
	}

	public Boolean deleteEssayById(String id) {

		int rst=dao.deleteByPrimaryKey(id);
		if (rst>0){
			return  true;
		}
		return false;
	}

	public List<Essay> getAllEssaiesByPage(String pageNum) {

		return dao.getAllEssaiesByPage(Integer.valueOf(pageNum));
	}

	public Essay getEssayInfo(String id) {
		//浏览一次,增加一次访问量
		dao.updateETImes(id);
		return  dao.getEssayInfo(id);
	}

	//新增点赞用户
	public Boolean agreeWithEssay(EssayAgree ea) {
		//Essay的点赞人数的增加由触发器完成
		int rst=eaDao.insertSelective(ea);
		if (rst>0){
			return  true;
		}
		return false;
	}

	//取消点赞
	public Boolean disAgreeWithEssay(String userid, String eid) {
		Map<String,String> map=new HashMap<>();
		map.put("userid",userid);
		map.put("eid",eid);
		int rst=eaDao.disAgreeWithEssay(map);
		if (rst>0){
			return  true;
		}
		return false;
	}


}
