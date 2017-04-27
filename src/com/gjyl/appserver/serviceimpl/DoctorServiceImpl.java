package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.DoctorMapper;
import com.gjyl.appserver.pojo.Doctor;
import com.gjyl.appserver.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Resource
	private DoctorMapper mapper;
	
	public List<Doctor> getRandomDr(){
		return mapper.getRandomDr();
	}

	public List<Doctor> getDrList() {
		
		return mapper.getDrList();
	}

	public Doctor getDrInfo(String docId) {
		return mapper.getDrInfo(docId);
	}

	public Boolean executeBatch(List<Object> list) {
		int rst=mapper.executeBatch(list);
		if (rst>0){
			return true;
		}
		return false;
	}
}
