package com.gjyl.appserver.service;

import com.gjyl.appserver.pojo.DiseaseLibraryWithBLOBs;

import java.util.List;

public interface DiseaseService {

	List<DiseaseLibraryWithBLOBs> getDiseaseList(String sectionId);

	DiseaseLibraryWithBLOBs getDiseaseById(String disId);

	List<DiseaseLibraryWithBLOBs> getAllDiseases();

	List<DiseaseLibraryWithBLOBs> getCommonDis();

	Boolean updateDisease(DiseaseLibraryWithBLOBs disease);

    Boolean addDisease(DiseaseLibraryWithBLOBs dlwb);
}

