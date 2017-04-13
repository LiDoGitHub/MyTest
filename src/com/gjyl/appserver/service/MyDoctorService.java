package com.gjyl.appserver.service;

import java.util.List;

import com.gjyl.appserver.pojo.MyDoctor;

public interface MyDoctorService {

	List<MyDoctor> getMyDoctor(String userId);

	Boolean addMyDoctor(MyDoctor myDoctor);

}
