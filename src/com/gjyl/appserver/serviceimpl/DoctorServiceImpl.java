package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.DocArrangementMapper;
import com.gjyl.appserver.dao.DoctorMapper;
import com.gjyl.appserver.pojo.DocArrangement;
import com.gjyl.appserver.pojo.Doctor;
import com.gjyl.appserver.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Resource
	private DoctorMapper mapper;
	@Resource
	private DocArrangementMapper arrDao;
	
	public List<Doctor> getRandomDr(){
		return mapper.getRandomDr();
	}

	public List<Doctor> getDrList() {
		
		return mapper.getDrList();
	}

	public Doctor getDrInfo(String docId) {
		Doctor doctor = mapper.getDrInfo(docId);
		DocArrangement arrangement= arrDao.getArrangeByDocId(docId);
		doctor.setArrangement(arrangement);
		return doctor;
	}

	public Boolean executeBatch(List<Object> list) {
		int rst=mapper.executeBatch(list);
		if (rst>0){
			return true;
		}
		return false;
	}
}
