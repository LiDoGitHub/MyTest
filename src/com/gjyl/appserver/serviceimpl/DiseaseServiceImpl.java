package com.gjyl.appserver.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.DiseaseLibraryMapper;
import com.gjyl.appserver.dao.DoctorMapper;
import com.gjyl.appserver.pojo.DiseaseLibraryWithBLOBs;
import com.gjyl.appserver.pojo.DoctorWithBLOBs;
import com.gjyl.appserver.service.DiseaseService;

@Service("diseaseService")
public class DiseaseServiceImpl implements DiseaseService {

	@Resource
	private DiseaseLibraryMapper dao;
	@Resource
	private DoctorMapper docDao;

	public List<DiseaseLibraryWithBLOBs> getDiseaseList(String sectionId) {
		
		return dao.getDiseaseList(sectionId);
	}

	public DiseaseLibraryWithBLOBs getDiseaseById(String disId) {
		//获取疾病+医生的信息
		DiseaseLibraryWithBLOBs disease = dao.getDiseaseById(disId);
		DoctorWithBLOBs doctor = docDao.getDrInfo(disease.getDoctorid());
		disease.setDoctor(doctor);
		return disease;
	}

	public List<DiseaseLibraryWithBLOBs> getAllDiseases() {
		
		return dao.getAllDiseases();
	}

	public List<DiseaseLibraryWithBLOBs> getCommonDis() {
		return dao.getCommonDis();
	}

	public Boolean updateDisease(DiseaseLibraryWithBLOBs disease) {
		int result=dao.updateDisease(disease);
		if (result>0) {
			return true;
		}
		return false;
	}
}
