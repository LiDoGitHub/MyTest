package com.gjyl.appserver.service;

import com.gjyl.appserver.pojo.Doctor;

import java.util.List;


public interface DoctorService {

	List<Doctor> getRandomDr();

	List<Doctor> getDrList();

	Doctor getDrInfo(String docId);

    Boolean executeBatch(List<Object> list);
}
