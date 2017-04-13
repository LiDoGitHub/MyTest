package com.gjyl.appserver.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.DiseaseLibraryMapper;
import com.gjyl.appserver.dao.SectionMapper;
import com.gjyl.appserver.pojo.DiseaseLibraryWithBLOBs;
import com.gjyl.appserver.pojo.Section;
import com.gjyl.appserver.service.SectionService;

@Service("sectionService")
public class SectionServiceImpl implements SectionService {

	@Resource
	private SectionMapper mapper;
	@Resource
	private DiseaseLibraryMapper disDao;
	
	public List<Section> getSecList() {
		List<Section> secList = mapper.getSecList();
		for (Section section : secList) {
			List<DiseaseLibraryWithBLOBs> disList = disDao.getDiseaseList(section.getSectionid());
			section.setDisList(disList);
		}
		return secList;
	}

}
