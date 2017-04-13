package com.gjyl.appserver.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.DoctorMapper;
import com.gjyl.appserver.pojo.DoctorWithBLOBs;
import com.gjyl.appserver.service.DoctorService;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Resource
	private DoctorMapper mapper;
	
	public List<DoctorWithBLOBs> getRandomDr(){
		return mapper.getRandomDr();
	}

	public List<DoctorWithBLOBs> getDrList() {
		
		return mapper.getDrList();
	}

	public DoctorWithBLOBs getDrInfo(String docId) {
		return mapper.getDrInfo(docId);
	}
}
