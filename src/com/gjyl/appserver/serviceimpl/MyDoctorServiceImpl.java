package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.DoctorMapper;
import com.gjyl.appserver.dao.MyDoctorMapper;
import com.gjyl.appserver.pojo.Doctor;
import com.gjyl.appserver.pojo.MyDoctor;
import com.gjyl.appserver.service.MyDoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("myDrService")
public class MyDoctorServiceImpl implements MyDoctorService {

	@Resource
	private MyDoctorMapper dao;

	@Resource
	private DoctorMapper docDao;
	public List<MyDoctor> getMyDoctor(String userId) {

		List<MyDoctor> list = dao.getMyDoctor(userId);
		for (MyDoctor doctor : list) {
			Doctor info = docDao.getDrInfo(doctor.getDoctorid());
			doctor.setDoctor(info);
		}
		return list;
	}
	public Boolean addMyDoctor(MyDoctor myDoctor) {
		int result= dao.addMyDoctor(myDoctor);
		if (result>0) {
			return true;
		}
		return false;
	}
	
}
