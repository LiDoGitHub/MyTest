package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.AppUserMapper;
import com.gjyl.appserver.dao.EssayAgreeMapper;
import com.gjyl.appserver.dao.EssayMapper;
import com.gjyl.appserver.dao.MyFocusesMapper;
import com.gjyl.appserver.pojo.AppUser;
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
	@Resource
	private MyFocusesMapper focDao;
	@Resource
	private AppUserMapper userDao;

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

	//分页显示所有说说
	public List<Essay> getAllEssaiesByPage(String pageNum,String userid) {

		List<Essay> list = dao.getAllEssaiesByPage(Integer.valueOf(pageNum));
		for (Essay essay:list) {//是否关注
			Map<String,String> map=new HashMap<>();
			map.put("pubUserId",essay.getUserid());
			map.put("userid",userid);
			int rst= focDao.isExist(map);
			if (rst>0){
				essay.setIsfocus(true);
			}else {
				essay.setIsfocus(false);
			}
			//用户信息
			AppUser user = userDao.getUserById(essay.getUserid());
			if (user.getName()!=null&&(!user.getName().equals(""))) {
				essay.setUser(user);
			}
		}

		return list;
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

	//我的关注
	public List<Essay> getFocusEssayByPage(String pageNum, String userid) {
		List<String> focUsers=focDao.getMyFocus(userid);//关注的用户列表
		if (focUsers.size()>0) {
			Map<String, Object> map = new HashMap<>();
			map.put("pageNum", Integer.valueOf(pageNum));
			map.put("list", focUsers);
			List<Essay> list = dao.getFocusEssayByPage(map);
			for (Essay essay : list) {
				//用户信息
				AppUser user = userDao.getUserById(essay.getUserid());
				if (user.getName() != null && (!user.getName().equals(""))) {
					essay.setUser(user);
				}
			}
			return list;
		}else {
			return null;
		}
	}


}
