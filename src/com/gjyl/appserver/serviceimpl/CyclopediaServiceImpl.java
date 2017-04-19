package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.CyclTypeMapper;
import com.gjyl.appserver.dao.CyclopediaMapper;
import com.gjyl.appserver.pojo.CyclType;
import com.gjyl.appserver.pojo.Cyclopedia;
import com.gjyl.appserver.service.CyclopediaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cyclopediaService")
public class CyclopediaServiceImpl implements CyclopediaService {

	@Resource
	private CyclopediaMapper mapper;
	@Resource
	private CyclTypeMapper typeMapper;

	public List<Cyclopedia> getRandomArt() {
		
		return mapper.getRandomAtr();
	}

	public List<Cyclopedia> getCyclByPage(Integer pageNum) {
		
		return mapper.getCyclByPage(pageNum);
	}

	public Cyclopedia getCyclInfo(String cyclId) {
		
		Cyclopedia cyclopedia = mapper.getCyclInfo(cyclId);
		CyclType type = typeMapper.getTypeById(cyclopedia.getTypeid());
		cyclopedia.setType(typeMapper.getTypeById(cyclopedia.getTypeid()));
		cyclopedia.setReadtimes(cyclopedia.getReadtimes()+1);
		mapper.updateCycl(cyclopedia);
		cyclopedia.setType(type);
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

		Map<String, Object>map= new HashMap<>();
		map.put("typeId", typeId);
		map.put("pageNum", Integer.valueOf(page));
		return mapper.getCyclByType(map);
	}

	
	public List<Cyclopedia> getHotCycl() {
		
		return mapper.getHotCycl();
	}

	public Boolean updateCyclopedia(Cyclopedia cyclopedia) {
		int rst=mapper.updateCycl(cyclopedia);
		if (rst>0){
			return true;
		}
		return false;
	}
}
