package com.gjyl.appserver.service;

import java.util.List;

import com.gjyl.appserver.pojo.DoctorWithBLOBs;


public interface DoctorService {

	public List<DoctorWithBLOBs> getRandomDr();

	public List<DoctorWithBLOBs> getDrList();

	public DoctorWithBLOBs getDrInfo(String docId);

}
