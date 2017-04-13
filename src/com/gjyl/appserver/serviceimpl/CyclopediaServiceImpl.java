package com.gjyl.appserver.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.CyclopediaMapper;
import com.gjyl.appserver.pojo.Cyclopedia;
import com.gjyl.appserver.service.CyclopediaService;

@Service("cyclopediaService")
public class CyclopediaServiceImpl implements CyclopediaService {

	@Resource
	private CyclopediaMapper mapper;

	public List<Cyclopedia> getRandomArt() {
		
		return mapper.getRandomAtr();
	}

	public List<Cyclopedia> getCyclByPage(Integer pageNum) {
		
		return mapper.getCyclByPage(pageNum);
	}

	public Cyclopedia getCyclInfo(String cyclId) {
		
		Cyclopedia cyclopedia = mapper.getCyclInfo(cyclId);
		cyclopedia.setReadtimes(cyclopedia.getReadtimes()+1);
		mapper.updateCycl(cyclopedia);
		return cyclopedia;
	}

	public List<Cyclopedia> getAllCyclopedias() {
		
		return mapper.getAllCyclopedias();
	}

	public Boolean addCycl(Cyclopedia cyclopedia) {
		
		Integer result= mapper.addCycl(cyclopedia);
		if (result>0) {
			return true;
		}
		return false;
	}

	public Boolean delCyclopedia(String cycId) {
		
		int result=mapper.delCyclopedia(cycId);
		if (result>0) {
			return true;
		}
		return false;
	}

	public List<Cyclopedia> getCyclByType(String typeId,String page) {

		Map<String, Object>map=new HashMap<String, Object>();
		map.put("typeId", typeId);
		map.put("pageNum", Integer.valueOf(page));
		return mapper.getCyclByType(map);
	}

	
	public List<Cyclopedia> getHotCycl() {
		
		return mapper.getHotCycl();
	}
}