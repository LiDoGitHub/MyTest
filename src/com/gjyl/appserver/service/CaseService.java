package com.gjyl.appserver.service;

import java.util.List;

import com.gjyl.appserver.pojo.Cases;

public interface CaseService {

	List<Cases> getMyCases(String userid);

	Boolean addCases(Cases cases);

	Cases getCaseInfo(String id);

	Boolean deleteCase(String id);

}
