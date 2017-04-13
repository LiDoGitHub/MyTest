package com.gjyl.appserver.service;

import java.util.List;

import com.gjyl.appserver.pojo.DiseaseLibraryWithBLOBs;

public interface DiseaseService {

	List<DiseaseLibraryWithBLOBs> getDiseaseList(String sectionId);

	DiseaseLibraryWithBLOBs getDiseaseById(String disId);

	List<DiseaseLibraryWithBLOBs> getAllDiseases();

	List<DiseaseLibraryWithBLOBs> getCommonDis();

	Boolean updateDisease(DiseaseLibraryWithBLOBs disease);
	
}

